<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
<title>Add Railway Crossing</title>

</head>

<body>

<h2>Add Railway Crossing</h2>



<form action="RailCrossing" method="POST"> <table>

<tr>

<td>Name:</td>

<td><input type="text" name="Name" required></td>

</tr>

<tr>

<td>Address:</td>

<td><input type="text" name="Address" required></td>

</tr>

<tr>

<td>Landmark:</td>

<td><input type="text" name="Landmark" required></td>

</tr>

<tr>

<td>Time Schedule:</td>

<td><input type="time" name="Trainschedule" required></td>

</tr>

<tr>

<td>Person In-Charge:</td>

<td><input type="text" name="pname" required></td> </tr>

<tr>

<td>Status:</td>

<td>

<input type="radio" name="status" value="Active" required> Active

<input type="radio" name="status" value="Inactive" required> Inactive

</td>

</tr>

<tr>

<td><input type="submit" value="Add Crossing"></td> </tr>

</table>
<a href="adminhome.jsp">Back to Admin Home</a>
</form>

</body>

</html>
