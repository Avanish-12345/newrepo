package com.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;

public class DatabaseUtilityTest 
{
Connection conn=null;
public void connectTodb() throws SQLException
{
	//step 1: Register database
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	
	//Step 2: Get connection for database
	conn=DriverManager.getConnection(IPathConstant.Dburl, IPathConstant.Dbusername,IPathConstant.Dbpassword);
			
}
public void executeAndgetData(String query,int cellindex,String expdata) throws SQLException
{
	//step 3: create statement
java.sql.Statement state=conn.createStatement();

//Step 4: Execute query/update query

 ResultSet result = state.executeQuery(query);
 boolean flag=false;
 while(result.next()) 
 {
	String actual=result.getString(cellindex);
	if(actual.contains(expdata))
	{
		flag=true;
		break;
		
	}
 }
 if(flag==true)
 {
	 System.out.println("Data is verified");
 }
 else
 {
	 System.out.println("Data is not  verified");
 }


}
public void closeDb() throws SQLException
{
	//Step 5: close db connection
	
	conn.close();
}
}
