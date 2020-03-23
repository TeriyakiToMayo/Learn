package com.javatpoint.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC_Util {
	private static Connection con;
	private static String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
	private static String username = "admin";
	private static String password = "admin";
	
	public static Connection getCon() {
		System.out.println("JDBC_Util getCon()");
		establishConnection();
		return con;
	}
	
	public static Connection provideCon() {
		System.out.println("JDBC_Util getCon()");
		establishConnection();
		return con;
	}
	
	public static void establishConnection() {
		try{
			System.out.println("Try to establish connection to Database");
			Class.forName("com.mysql.jdbc.Driver");  
			con = DriverManager.getConnection(  
	    				url,username,password);  
			System.out.println("Database Connection Establishment Succeeded!");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*
	public static void main(String[] args) {
		establishConnection();
	}
	*/
}
