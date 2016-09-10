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
<script type="text/javascript">
function selectQuantity(){
var quantity = document.getElementById("selectquantity");
var selectedValue = quantity.options[quantity.selectedIndex].value;
return selectedvalue;
}</script>
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
				<li  class="current"><a href="BuyerProducts.jsp">Products</a></li>
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
			<h1>Departments</h1>
			<ul>
				<li><a href="BuyerProductServlet?param1=All">All</a></li>
				<li><a href="BuyerProductServlet?param1=Living Room">Living Room</a></li>
				<li><a href="BuyerProductServlet?param1=Bed Room">Bed Room</a></li>
				<li><a href="BuyerProductServlet?param1=Kitchen and Dining">Kitchen and Dining</a></li>
			</ul>
				<%@ page
					import="java.util.*,java.util.List,java.util.List,java.util.List,FW.*"%>
				<%
				List<Product> plist =(List<Product>)request.getAttribute("plist");

				if (plist!=null){ %>
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
						for (int i = 0; i < plist.size(); i++) {
						%>
						<tr>
							<td><%=plist.get(i).getProductname() %></td>
							<td><%=plist.get(i).getDescription() %></td>
							<td><%=plist.get(i).getQuantity() %></td>
							<td><%=plist.get(i).getCompanyname() %></td>
							<td><%=plist.get(i).getPrice() %></td>
							  <%authDAO_signup AD=new authDAO_signup();
								String uname=(String) session.getAttribute("name");
								int cartid=AD.retrieveCartid(uname);
								int productid=plist.get(i).getProductid();
								int requestQuantity=plist.get(i).getProductid();%>
	
							
							<td>
							<a href="AddToCart?param1=<%=cartid%>&param2=<%=productid%>&param3=1"><button>Add To Cart</button></a></td>
							
							</tr><%}} %>
					</table>
		</div>
	</div>
			<div id="body">		<div id="figure">
		<a href="Products.jsp"><img src="images/bed.jpg" alt="Image"></a><a href="Products.jsp"><img src="images/dining.jpg" alt="Image"></a>
		</div></div>
	</body>
</html>