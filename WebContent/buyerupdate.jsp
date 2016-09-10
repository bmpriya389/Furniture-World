<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Furniture World</title>
	<link rel="stylesheet" type="text/css" href="style_index.css" />
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
				<li><a href="Buyer.jsp">Home</a></li>
				<li><a href="BuyerAbout.jsp">About</a></li>
				<li><a href="BuyerProducts.jsp">Products</a></li>
				<li><a href="BuyerContact.jsp">Contact</a></li>		
		</ul>
			
			<form action="BuyerSearchServlet" method="post">
			
				<input type="text" name="search"> <input
					type="submit" value="Search" id="searchbtn">
			</form>
	</div>
		

</div>
<div id="body">
		<div id="products">		
		<div>

<form action=Buyerupdateservlet method="post">
<h1><center>Update Profile</center></h1>
				
		<table align=center>
			<tr>
				<td>User Name</td>
				<td><input type="text" name="uname"></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="fname"></td>
			</tr>
			<tr>
				<td>Middle Name</td>
				<td><input type="text" name="mname"></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lname"></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><textarea id="address" name="address" rows=3 cols=30></textarea></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td>Email Address:</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td colspan=2><center><input type="submit" name="update" value="UPDATE"></center></td>
			</tr>
		</table>
	</form></div></div></div>
</body>
</html>