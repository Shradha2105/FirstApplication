package com.cpa.jdbc;
import java.io.*;
import java.sql.*;


	

public 	class GFG {
		public static void main(String[] args) throws Exception
		{
			String url
				= "jdbc:postgresql://localhost:5432/payslip"; // table details
			String username = "postgres"; // MySQL credentials
			String password = "Pass1word";
			String query
				= "select * from employee"; // query to be run
			Class.forName(
				"org.postgresql.Driver"); // Driver name
			Connection con = DriverManager.getConnection(
				url, username, password);
			System.out.println(
				"Connection Established successfully");
			Statement st = con.createStatement();
			ResultSet rs
				= st.executeQuery(query); // Execute query
			while(rs.next())
			{
			String name
				= rs.getString("emp_name"); // Retrieve name from db
			
			System.out.println(name); 
			}// Print result on console
			st.close(); // close statement
			con.close(); // close connection
			System.out.println("Connection Closed....");
		}
	}


