<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
 <h2>Welcome, <% session.getAttribute("username"); %>!</h2>
    <p>This is a secured page.</p>
    <p><a href="LogoutServlet">Logout</a></p>
</body>
</html>