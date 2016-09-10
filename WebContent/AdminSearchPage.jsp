<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products - Furniture World</title>
	<link rel="stylesheet" type="text/css" href="style_index.css">
	<style>
table {
    border-collapse: collapse;
}

table, td, th {
    border: 3px solid lightblue;
    padding: 5x;

}
table, th{
    background-color: #072740;
    color: #ffffff;
    font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
}
table, td{
    padding: 5px;
    background-color: #FFFFFF;
    color: #000000;
    font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
}

</style>
	
</head>
<body>
<div id="header">

		<%
			if (session.getAttribute("utype")==null) {
		%>
		<a href="index.jsp"><img src="images/logo.gif" alt="Image"></a>
		<a href="Login.jsp"><button>Login</button></a> <a href="Signup.jsp"><button>Sign
				Up</button></a>
		<%
			} else if (session.getAttribute("utype").equals("B")) {
		%>
		<a href="Buyer.jsp"><img src="images/logo.gif" alt="Image"></a>
		<a href="shoppingcart.jsp"><button>Shopping Cart</button></a> <a
			href="index.jsp"><button>Logout</button></a>
		<%
			} else if (session.getAttribute("utype").equals("S")) {
		%>
		<a href="Seller.jsp"><img src="images/logo.gif" alt="Image"></a>
		<a href="index.jsp"><button>Logout</button></a>
		<%
			}
		%>

		
		<div>
			<ul>
				<li>
					<a href="index.jsp">Home</a>
				</li>
				<li>
					<a href="about.jsp">About</a>
				</li>
				<li class="current">
					<a href="Products.jsp">Products</a>
				</li>
				<li>
					<a href="contact.jsp">Contact</a>
				</li>
			</ul>
			<form action="SearchServlet">
				<input type="text" id="search" value="">
				<input type="submit" value="Search" id="searchbtn">
			</form>
		</div>
	</div>
	
	<div id="body">
		<div id="products">
			<h1>Products</h1>
			<center><h1>Search Results</h1></center>
			<ul>
				<li><a href="ProductServlet?param1=Living Room">Living Room</a></li>
				<li><a href="ProductServlet?param1=Bed Room">Bed Room</a></li>
				<li><a href="ProductServlet?param1=Kitchen and Dining">Kitchen and Dining</a></li>
			</ul>
				<%@ page
					import="java.util.ArrayList,java.util.List,java.util.List,java.util.List,FW.*"%>
				<%
				List<Product> searchlist =(List<Product>)request.getAttribute("searchlist");

				if (searchlist!=null){ %>
					<table>
						<tr>
							<td>Product Name</td>
							<td>Description</td>
							<td>Available Quantity</td>
							<td>Company Name</td>
							<td>Price</td>
							<td>Add to cart?</td>
						</tr>

						<%
						for (int i = 0; i < searchlist.size(); i++) {
						%>
						<tr>
							<td><%=searchlist.get(i).getProductname() %></td>
							<td><%=searchlist.get(i).getDescription() %></td>
							<td><%=searchlist.get(i).getQuantity() %></td>
							<td><%=searchlist.get(i).getCompanyname() %></td>
							<td><%=searchlist.get(i).getPrice() %></td>
							  <%authDAO_signup AD=new authDAO_signup();
								String uname=(String) session.getAttribute("name");
								int cartid=AD.retrieveCartid(uname);
								int productid=searchlist.get(i).getProductid();
								int requestQuantity=searchlist.get(i).getProductid();%>
							<td>
							<a href="AddToCart?param1=<%=cartid%>&param2=<%=productid%>&param3=1"><button>Add To Cart</button></a></td>
							</tr><%}}%>
					</table>
		</div>
	</div>
			<div id="body">		<div id="figure">
		<a href="Products.jsp"><img src="images/bed.jpg" alt="Image"></a><a href="Products.jsp"><img src="images/dining.jpg" alt="Image"></a>
		</div></div>
	</body>
</html>