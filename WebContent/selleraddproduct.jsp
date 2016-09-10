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
			<form action=Selleraddprodservlet method="post">
				<h1><center>Add Products</center></h1>
					<table align=center>
			<tr>
				<td>Product name</td>
				<td><input type="text" name="pname"></td>
			</tr>
			<tr>
				<td>Company Name</td>
				<td><input type="text" name="cname"></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><textarea id="address" name="desc" rows=3 cols=30></textarea></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td><select id="selectquantity" name="quantity">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option></select></td>
			</tr>
			<tr>
				<td>Departmemt</td>
				<td><select id="select_dept" name="dept">
								<option value="Bed Room">Bed Room</option>
								<option value="Kitchen and Dining">Kitchen and Dining</option>
								<option value="Living Room">Living Room</option>
								</select></td>
			</tr>
			<tr>
				<td>Image</td>
				<td><input type="file" name="file"></td>
			</tr>
			<tr>
				<td colspan=2><center><input type="submit" name="save" value="Save"></center></td>
			</tr>
		</table>
	</form>
	</div>
	</div>
	</div>
	</body>
</html>