package com.thiennh.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setup connection variables
		String jdbcURL = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String jdbcUser = "springstudent1";
		String jdbcPassword = "springstudent1";
		String driver = "com.mysql.jdbc.Driver";

		// get connection to database
		try {
			PrintWriter out = response.getWriter();
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPassword);
			System.out.println("Thanh Cong!");
			out.print("Thanh Cong!");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
