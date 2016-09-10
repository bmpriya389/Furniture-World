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

		<a href="Seller.jsp"><img src="images/logo.gif" alt="Image"></a>
		<a href="SellerViewOrder"><button>View Orders</button></a> <a
			href="sellerupdate.jsp"><button>Edit Profile</button></a>
<%-- <a href="CloseSellerAccount?param1=<%=session.getAttribute("name")%>"><button>Close Seller Account</button></a> --%>
		<a href="selleraddproduct.jsp"><button>Add Product</button></a>
			<a href="LogoutServlet?param1=<%=session.getAttribute("name")%>"><button>Logout</button></a>

		<%
			String uname = (String) session.getAttribute("name");
		%>
		<div>
			<ul>
				<li><a href="Seller.jsp">Home</a></li>
				<li><a href="SellerAbout.jsp">About</a></li>
				<li><a href="SellerProductList?param1=<%=uname%>">Products</a></li>
				<li><a href="SellerContact.jsp">Contact</a></li>
			</ul>		<form action="SellerSearchServlet" method="post">
			
				<input type="text" name="search"> <input
					type="submit" value="Search" id="searchbtn">
			</form>

		</div>


	</div>
	<div id="body">
		<div id="products">
			<br>
			<br>
			<div>
				<form action=Sellerupdateservlet method="post">
					<h1>
						<center>Update Profile</center>
					</h1>
					<table align=center>
						<tr>
							<td>UserName</td>
							<td><input type="text" name="uname"></td>
						</tr>
						<tr>
							<td>Company Name</td>
							<td><input type="text" name="cname"></td>
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
							<td>PayPal Account</td>
							<td><input type="text" name="paypalacct"></td>
						</tr>
						<tr>
							<td colspan=2><center>
									<input type="submit" name="update" value="Update">
								</center></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		</div>
</body>
</html>