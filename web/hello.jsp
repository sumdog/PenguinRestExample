<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html  xmlns="http://www.w3.org/1999/xhtml" dir="ltr" >
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Sample Page</title>
</head>
<body>
	<p>
		<img src="images/penguindreams.gif" alt="PenguinDreams" />
		<br />
		TimeStamp: <%= request.getAttribute("timeStamp") %>
	</p>
</body>
</html>