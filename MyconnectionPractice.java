package com.jdbcproject2;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyconnectionPractice 
{
	public static void main(String[] args)
	{
		//ConnectionPractice.createTable();
		//ConnectionPractice.insert("Ram");
		//ConnectionPractice.select();
		//ConnectionPractice.delete(3);
		//ConnectionPractice.selectById(5);
		
	}
}
class ConnectionPractice
{
	static String url="jdbc:mysql://localhost:3306/palle";
	static String user="root";
	static String pass="BUNNYprem@1610";
	static Connection con=null;
	static Statement s=null;
	static PreparedStatement ps=null;
	public static void createTable()
	{
		String create="create table student(id int primary key auto_increment,Student_name varchar(40))";
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, pass);
			Statement s=con.createStatement();
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
	public static void insert(String name)
	{
		String insert="insert into student(Student_name) values(?)";
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, pass);
			ps=con.prepareStatement(insert);
			ps.setString(1, name);
			ps.executeUpdate();
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
				ps.close();
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	public static void select()
	{
		String select="select*from student";
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, pass);
			s=con.createStatement();
			ResultSet rs=s.executeQuery(select);
			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				System.out.println(id+" "+name);
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
	public static void delete(int id)
	{
		String delete="delete from student where id=? ";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, pass);
			ps=con.prepareStatement(delete);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				ps.close();
				con.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	public static void selectById(int id)
	{
		String selectId=" select * from student where id=? ";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, pass);
			ps=con.prepareStatement(selectId);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				int id1=rs.getInt(1);
				String name=rs.getString(2);
				System.out.println(id1+" "+name);
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
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
