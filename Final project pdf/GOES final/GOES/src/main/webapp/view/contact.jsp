<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
ContactPage

<a href="aboutpage">About</a>
<a href="servicepage">Service</a>
<a href="contactpage">Contact</a>
<a href="loginpage">LogOut</a>

<form action="contactdata" method="post">
Name<input type="text" name="name">
Address<input type="text" name="address">
Mobile<input type="text" name="mobile">
Email<input type="text" name="email">

<input type="submit" value="contactSave">
<input type="reset" value="reset">

</form>

</body>
</html>