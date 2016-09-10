<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>About Us</title>
<link rel="stylesheet" type="text/css" href="style_index.css">
<title>Insert title here</title>
</head>
<body>
	<div id="header">
		
		<a href="Admin.jsp"><img src="images/logo.gif" alt="Image"></a>
		<a href="LogoutServlet?param1=<%=session.getAttribute("name")%>"><button>Logout</button></a>
		<div>
			<ul>
	<li><a href="Admin.jsp">Home</a></li>
				<li class="current"><a href="AdminAbout.jsp">About</a></li>
				<li><a href="AdminProducts.jsp">Products</a></li>
				<li><a href="AdminContact.jsp">Contact</a></li>
	
		
			</ul>
			<form action="SearchServlet">
				<input type="text" id="search" value=""> <input
					type="submit" value="Search" id="searchbtn">
			</form>
		</div>
	</div>
	<div id="body">
		<div id="products">

			<h1>About Us</h1>
			Developed by the Furniture World
			Team&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

		</div>
	</div>
	<div id="body">
		<div id="figure">
			<a href="Products.jsp"><img src="images/bed.jpg" alt="Image"></a><a
				href="Products.jsp"><img src="images/dining.jpg" alt="Image"></a>
		</div>
		<div id="footer"></div>
</body>
</html>