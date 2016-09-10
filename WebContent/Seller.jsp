<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Furniture World</title>
<link rel="stylesheet" type="text/css" href="style_index.css">
<title>Seller Home Page</title>
</head>
<body>
	<div id="header">
		<a href="Seller.jsp"><img src="images/logo.gif" alt="Image"></a>
		<a href="SellerViewOrder"><button>View Orders</button></a>	
		<a href="sellerupdate.jsp"><button>Edit Profile</button></a>
		<%-- <a href="CloseSellerAccount?param1=<%=session.getAttribute("name")%>"><button>Close Seller Account</button></a> --%>
		<a href="selleraddproduct.jsp"><button>Add Product</button></a>
		<a href="LogoutServlet?param1=<%=session.getAttribute("name")%>"><button>Logout</button></a>

		<% String uname=(String)session.getAttribute("name");%>
		<div>
			<ul>
				<li class="current"><a href="Seller.jsp">Home</a></li>
				<li><a href="SellerAbout.jsp">About</a></li>
				<li><a href="SellerProductList?param1=<%=uname%>">Products</a></li>
				<li><a href="SellerContact.jsp">Contact</a></li>

			</ul>
					<form action="SellerSearchServlet" method="post">
			
				<input type="text" name="search"> <input
					type="submit" value="Search" id="searchbtn">
			</form>
</div>
	</div>
	<div id="body">
		<h2>Seller Home Page</h2>

</div>	<div id="body"><div id="figure">
			<a href="Products.jsp"><img src="images/dining-table.jpg"
				alt="Image"></a><a href="Products.jsp"><img
				src="images/room.jpg" alt="Image"></a>
		</div></div>
	<div id="footer"></div>
</body>
</html>