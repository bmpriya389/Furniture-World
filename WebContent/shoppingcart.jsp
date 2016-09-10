<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style_index.css">
<title>Cart</title>
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
			</form>		</div>
	</div>
	<div id="body">
		<div id="products">

			<h1>Shopping cart</h1>
			<div>
				<%@ page
					import="java.util.ArrayList,java.util.List,java.util.List,java.util.List,FW.*"%>
				<div>
					<table>
						<tr>
							<td>Product Name</td>
							<td>Description</td>
							<td>Quantity</td>
							<td>Company Name</td>
							<td>Price</td>
							<td>Date Added</td>
							<td>Remove?</td>
						</tr>

						<%
					authDAO_signup AD = new authDAO_signup();
					List<CartItems> cart = new ArrayList<CartItems>();
					String uname = (String) session.getAttribute("name");
					cart = AD.retrieveCart(uname);
					for (int i = 0; i < cart.size(); i++) {
						%>
						<tr>
							<td><%=cart.get(i).getProductname() %></td>
							<td><%=cart.get(i).getDescription() %></td>
							<td><%=cart.get(i).getQuantity() %></td>
							<td><%=cart.get(i).getCompanyname() %></td>
							<td><%=cart.get(i).getQuantity()*cart.get(i).getPrice() %></td>
							<td><%=cart.get(i).getDateadded() %></td>
							<%int cartid=cart.get(i).getCartid();%>
							<%int productid=cart.get(i).getProductid();%>
							<%int quantity=cart.get(i).getQuantity();%>
							<td><a href="ShoppingCart?param1=<%=cartid%>&param2=<%=productid%>&param3=<%=quantity%>"><button>Remove</button></a></td>
							</tr><%}%>
					</table>
				</div>
			</div>
			<br>
			
			<h2></h2>
		</div>
	</div>
		<div id="figure"></div>
		<div id="footer"></div>
</body>
</html>