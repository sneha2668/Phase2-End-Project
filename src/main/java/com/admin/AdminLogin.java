package com.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;


/**
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
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
		try{

			PrintWriter out= response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/railway","root ","@Sneha7911");

			String uname = request.getParameter("uname"); 
			String pass = request.getParameter("password");

			PreparedStatement ps = con.prepareStatement("SELECT uname FROM admin WHERE uname=? AND password=?");

			ps.setString(1,uname);

			ps.setString(2,pass);

			ResultSet rs = ps.executeQuery();
			 

			if(rs.next()) {

			RequestDispatcher rd = request.getRequestDispatcher("adminhome.jsp");

			rd.forward(request, response);

			}

			else {

			out.println("<font color=red size=4>Login Failed!!!<br>");

			out.println("<font color=red size=2>Invalid user name or password<br>"); 
			out.println("<a href=login.jsp>Try Again</a>"); }

			}catch (ClassNotFoundException e) {

			e.printStackTrace();

			} catch (SQLException e) {

//				TODO Auto-generated catch block
				e.printStackTrace();

			}

		}
	}