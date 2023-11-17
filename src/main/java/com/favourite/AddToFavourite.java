package com.favourite;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection; 
import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.SQLException;


/**
 * Servlet implementation class AddToFavourite
 */
public class AddToFavourite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToFavourite() {
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
		String itemId = request.getParameter("itemId");



//		Perform necessary operations to add the item to favorites 
	try {

//		Establish database connection

	Class.forName("com.mysql.jdbc.Driver"); 
	Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/railway", "root", "@Sneha7911");


	// Prepare SQL statement to insert the favorite crossing
	 
	String sql = "INSERT INTO favourites (id, Name, Address, Landmark, Trainschedule, pname, status) " +

	"SELECT id, Name, Address, Landmark, Trainschedule, pname, status " + "FROM adminhome WHERE id = ?";

	PreparedStatement statement = connection.prepareStatement(sql); 
	statement.setString(1, itemId);


	// Execute the SQL statement

	int rowsAffected = statement.executeUpdate();



//		Close the database connection 
	statement.close(); 
	connection.close();



//		Redirect the user back to the user home page 
	response.sendRedirect("userhome.jsp");

	} catch (ClassNotFoundException | SQLException e)
	{ 
		e.printStackTrace();

	}

	}

	}



