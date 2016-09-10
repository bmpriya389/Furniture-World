<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Furniture World</title>
	<link rel="stylesheet" type="text/css" href="style_index.css">
</head>
<body>
<div id="header">
			<a href="index.jsp"><img src="images/logo.gif" alt="Image"></a>
			<a href="Login.jsp"><button>Login</button></a> <a href="Signup.jsp"><button>Sign
			Up</button></a>
		<div>
			<ul>
				<li class="current">
					<a href="index.jsp">Home</a>
				</li>
				<li>
					<a href="AboutUs.jsp">About</a>
				</li>
				<li>
					<a href="Products.jsp">Products</a>
				</li>
				<li>
					<a href="contact.jsp">Contact</a>
				</li>
			</ul>	<form action="SearchServlet" method="post">
			
				<input type="text" name="search"> <input
					type="submit" value="Search" id="searchbtn">
			</form>
		
		</div>
	</div>
	<div id="body">
		<div id="figure">
		<a href="Products.jsp"><img src="images/dining-table.jpg" alt="Image"></a><a href="Products.jsp"><img src="images/room.jpg" alt="Image"></a>
		</div>
		
	</div>
	<div id="footer"></div>
</body>
</html>