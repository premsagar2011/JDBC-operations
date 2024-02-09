package com.jdbcproject2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertAnImageToDB 
{

	public static void main(String[] args) 
	{
		//Image.createTable();
		Image.insertTable("ravi", 20000, "C://Users//Prem Sagar//Downloads//Prem Sagar HS_Trained Java full Stack Developer_resume.pdf");
	}
}
class Image
{
	static String url="jdbc:mysql://localhost:3306/palle";
	static String username="root";
	static String password="BUNNYprem@1610";
	static Connection con=null;
	static Statement s=null;
	static String create="create table myimage(id int primary key auto_increment,name varchar(40),salary int,image longblob)";
	static String insert="insert into myimage(name,salary,image)values(?,?,?)";
	public static void createTable() 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			s=con.createStatement();
			s.executeUpdate(create);
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
	public static void insertTable(String name,int salary,String image)
	{
		PreparedStatement ps=null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			ps=con.prepareStatement(insert);
			ps.setString(1, name);
			ps.setInt(2, salary);
			FileInputStream fs=new FileInputStream(image);
			ps.setBinaryStream(3, fs, fs.available());
			ps.executeUpdate();
			
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				ps.close();
				con.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
