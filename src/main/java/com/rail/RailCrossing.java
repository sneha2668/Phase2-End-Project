package com.rail;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RailCrossing
 */
public class RailCrossing extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String DRIVER_CLASS="com.mysql.cj.jdbc.Driver";
	public static final String DB_URL="jdbc:mysql://localhost:3306/railways";
	public static final String USERNAME="root";
	public static final String PASSWORD="@Sneha7911";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RailCrossing() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("Name");
		String address = request.getParameter("Address");
		String landmark = request.getParameter("Landmark");
		String trainSchedule = request.getParameter("Trainschedule");
		String personInCharge = request.getParameter("pname");
		String status = request.getParameter("status");
		RailCross railCrossing = new RailCross(name, address, landmark, trainSchedule, personInCharge,status);
		String result = insertRailCrossing(railCrossing); response.getWriter().print(result); }
		private String insertRailCrossing(RailCross railCrossing) { try {
		Class.forName(DRIVER_CLASS);
		Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		String sql = "INSERT INTO adminhome (Name, Address, Landmark, Trainschedule, pname, status) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, railCrossing.getName());
		statement.setString(2, railCrossing.getAddress()); 
		statement.setString(3, railCrossing.getLandmark());
		statement.setString(4, railCrossing.getTrainSchedule());
		statement.setString(5, railCrossing.getPersonInCharge());
		statement.setString(6, railCrossing.getStatus());
		int rowsInserted = statement.executeUpdate(); if (rowsInserted > 0) {
		return "Data inserted successfully";
		} else {
		return "Failed to insert data";
		}
		} catch (ClassNotFoundException | SQLException e) { e.printStackTrace();
		return "Error: " + e.getMessage();
		}
		}
		

}
