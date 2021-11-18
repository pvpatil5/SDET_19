package com.genericutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class JDBCUtil {
@Test
public void getExecuteQuery() throws SQLException
{
Driver driverref=new Driver();
DriverManager.registerDriver(driverref);
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "admin");
Statement stat = con.createStatement();
ResultSet result = stat.executeQuery("select * from project");
while(result.next())
{
	System.out.println(result.getString(1));
}

}
}
