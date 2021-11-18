package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecuteQuery {
	@Test
	public void getExecteUpdate() throws SQLException
	{
		Connection con=null;
		try {
		Driver driverref=new Driver();
		  DriverManager.registerDriver(driverref);
		  //Step 2:establish connection with database
		   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "admin");
		        //Step 3:issue create statement
		  Statement stat=con.createStatement();
		  //Step 4:Execute the query
		  int result=stat.executeUpdate("insert into project values('ROJ_012','Rock','07/10/2021','SDET22','ON-GOING',22);");
		  if(result==1)
		  {
		   System.out.println("project is created successfully");
		  }
		  else
		  {
		   System.out.println("query failed");
		  }
		}
		catch(Exception e) {
			
		}
		finally {
			con.close();
		}

	}
}
