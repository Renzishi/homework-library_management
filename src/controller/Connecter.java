package controller;

import java.sql.*;
import java.io.*;
import java.util.Properties;


public class Connecter {
	private static String DBName;
	private static String acc;
	private static String pwd;
	public static Connection connectDB(){
		Connection con = null;
		getProperties();
		String url = "jdbc:mysql://localhost:3306/"+DBName+
		"?useSSL=true&&serverTimezone=CST&characterEncoding=utf-8";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(Exception e) {
			System.out.println("DB Driver loading failed");
		}
		
		try {
			con = DriverManager.getConnection(url, acc, pwd);
		}catch(SQLException e) {
			System.out.println("DB connection failed");
		}
		
		return con;
	}

	public static void getProperties() {
		Properties properties = new Properties();
		File file = new File("./config.properties");
		if (!file.exists()) {
			try {
				file.createNewFile();
				FileWriter write = new FileWriter(file);
				write.write("DBName=bookstore\nacc=root\npwd=admin\n");
				write.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			InputStream in = new FileInputStream(file);
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}

		DBName = properties.getProperty("DBName");
		acc = properties.getProperty("acc");
		pwd = properties.getProperty("pwd");
	}
}
