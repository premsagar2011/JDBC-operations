package com.jdbcproject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcProject2 
{

	public static void main(String[] args) 
	{
		/*
		 * String url="jdbc:mysql://localhost:3306/palle"; 
		 * String user="root";
		 * String pass="BUNNYprem1610";
		 */
		Statement s=null;
		Connection con=null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/palle","root", "BUNNYprem@1610");
			s=con.createStatement();
			s.executeUpdate("create table studentpalle (sid int,sname varchar (40));");
			s.executeUpdate("insert into studentpalle values(1,'pavan')");
			s.executeUpdate("insert into studentpalle values(2,'pavan ram')");
			s.executeUpdate("update studentpalle set sname='pavan HN' where sid=1");
			s.execute("delete from studentpalle where sid =1");
			s.execute("drop table studentpalleof");
			ResultSet res=s.executeQuery("select * from studentpalle");
			while(res.next()==true)
			{
				System.out.println("sid "+res.getInt(1)+" sname= "+res.getString(2));
			}	
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				s.close();
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
