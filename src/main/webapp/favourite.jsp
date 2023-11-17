<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>

<%@ page import="javax.servlet.http.*,javax.servlet.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%> <!DOCTYPE html>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Favourite Crossing</title>

</head>

<body>

<h2>Favourite Crossing</h2>

<a href="userhome.jsp">Home</a><br>

<a href="search.jsp">Search Crossing</a><br><br>

<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"

url="jdbc:mysql://localhost:3306/railway" user="root" password="@Sneha7911" />



<sql:query dataSource="${snapshot}" var="favourites"> SELECT * FROM favourites;

</sql:query>



<c:if test="${not empty favourites.rows}"> <table border="1" width="100%"> <tr>

<th>Sr.No</th>

<th>Name</th>

<th>Address</th>

<th>Landmark</th>

<th>Time Schedule</th>

<th>Person In-Charge</th>

<th>Status</th>

</tr>

<c:forEach var="favourite" items="${favourites.rows}"> <tr>

<td><c:out value="${favourite.id}" /></td>

<td><c:out value="${favourite.Name}" /></td>

<td><c:out value="${favourite.Address}" /></td>

<td><c:out value="${favourite.Landmark}" /></td>

<td><c:out value="${favourite.Trainschedule}" /></td>

<td><c:out value="${favourite.pname}" /></td>

<td><c:out value="${favourite.status}" /></td>

</tr>

</c:forEach>

</table>

</c:if>

<c:if test="${empty favourites.rows}">

<p>No favourite crossings.</p>
 
</c:if>

</body>

</html>

