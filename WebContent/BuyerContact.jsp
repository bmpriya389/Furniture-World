<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Us</title>
	<link rel="stylesheet" type="text/css" href="style_index.css">
<title>Insert title here</title>
</head>
<body>
<div id="header">
		<a href="Buyer.jsp"><img src="images/logo.gif" alt="Image"></a>
		<a href="shoppingcart.jsp"><button>Shopping Cart</button></a> 
		<a href="buyerupdate.jsp"><button>Edit Profile</button></a>	
		<a href="BuyerViewOrder"><button>View Orders</button></a>	
		<a href="LogoutServlet?param1=<%=session.getAttribute("name")%>"><button>Logout</button></a>
	
	
		<div>
			<ul>
				<li>
					<a href="Buyer.jsp">Home</a>
				</li>
				<li>
					<a href="BuyerAbout.jsp">About</a>
				</li>
				<li>
					<a href="BuyerProducts.jsp">Products</a>
				</li>
				<li class="current">
					<a href="BuyerContact.jsp">Contact</a>
				</li>	
			</ul>
			<form action="BuyerSearchServlet" method="post">
			
				<input type="text" name="search"> <input
					type="submit" value="Search" id="searchbtn">
			</form>

		</div>
	</div>
	<div id="body">
	<div id="products">
		
	<h1>Contact</h1>
	Team Members:<br>
	Tejas, Priya, Oguz, Bhavana
	</div></div>
	<div id="body">
		<div id="figure">
		<a href="Products.jsp"><img src="images/bed.jpg" alt="Image"></a><a href="Products.jsp"><img src="images/dining.jpg" alt="Image"></a>
		</div>
		</div>
<div id="footer"></div>		
</body>
</html>