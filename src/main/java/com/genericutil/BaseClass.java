package com.genericutil;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.objectrepo.HomePage;
import com.objectrepo.LoginPage;


public class BaseClass
{
	public  WebDriver driver;
	public WebDriver_Utility wdu = new WebDriver_Utility();
	public FileUtility fileutility = new FileUtility();
	ExtentHtmlReporter reporter; // To apply look and feel of the report to set the path of extent report
	public ExtentReports report; // Attach the path of reporter 
	public	ExtentTest test;// To create entries in the test cases 
	public static	WebDriver staticdriver;



	@BeforeSuite(groups = {"Smoke Test","Regression Test"})
	public void setup_JDBC_Report() 
	{
		System.out.println("=====JDBC Connection Done====");
		reporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/SDET19/newreport.html");//imp
		reporter.config().setDocumentTitle("SDET12Report");
		reporter.config().setReportName("Title");
		reporter.config().setTheme(Theme.DARK);

		report= new ExtentReports();//imp
		report.attachReporter(reporter);//imp
	}

	@AfterSuite(groups = {"Smoke Test","Regression Test"})
	public void close_JDBC_Report() {
		report.flush();
		System.out.println("=====JDBC Connection Closed====");
	}


	//@Parameters("BROWSER")
	@BeforeClass(groups = {"Smoke Test","Regression Test"})
	public void launchBrowser() throws IOException 
	{
		String BROWSER = System.getProperty("browser");
		//String BROWSER =fileutility.readDatafrompropfile("browser");

		if(BROWSER.equalsIgnoreCase("Chrome")) 
		{
			driver= new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("Firefox"))
		{
			driver= new FirefoxDriver();
		}
		else {
			driver= new ChromeDriver();
		}
		String url = System.getProperty("URL");
		staticdriver=driver;
		driver.get(url);
		wdu.maximizewindow(driver);
		wdu.pageloadtimeout(driver);
	}

	@AfterClass(groups = {"Smoke Test","Regression Test"})
	public void closeBrowser() 
	{
		driver.close();
	}

	@BeforeMethod(groups = {"Smoke Test","Regression Test"})
	public void logintoVtiger() throws IOException 
	{
		LoginPage lp = new LoginPage(driver);
		lp.loginintoApp();
	}

	@AfterMethod(groups = {"Smoke Test","Regression Test"})
	public void logoutVtiger(ITestResult result) throws InterruptedException, IOException
	{
		HomePage hp = new HomePage(driver);
		if(result.getStatus()==ITestResult.FAILURE) 
		{
			test.log(Status.FAIL, result.getName());//name of failed method
			test.log(Status.FAIL, result.getThrowable());//Error msg

			String	path=BaseClass.getscreenshot(result.getName());

			test.addScreenCaptureFromPath(path);

		}
		else if (result.getStatus()==ITestResult.SUCCESS) 
		{
			test.log(Status.PASS, result.getName());
			hp.logoutfromApp();
		}
		else if (result.getStatus()==ITestResult.SKIP) 
		{
			test.log(Status.SKIP, result.getName());
		}
	}
	public static String getscreenshot( String name) throws IOException 
	{
		File srcfile =((TakesScreenshot) staticdriver).getScreenshotAs(OutputType.FILE);
		String destfile= System.getProperty("user.dir")+"/Screenshots/"+name+".png";
		File finaldest = new File(destfile) ;
		FileUtils.copyFile(srcfile,finaldest);

		return destfile;
	}

}
