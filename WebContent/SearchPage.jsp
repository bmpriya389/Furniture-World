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

<a href="index.jsp"><img src="images/logo.gif" alt="Image"></a>
		<a href="Login.jsp"><button>Login</button></a> <a href="Signup.jsp"><button>Sign
				Up</button></a>
				<div>
			<ul><li><a href="index.jsp">Home</a></li>
				<li><a href="AboutUs.jsp">About</a></li>
				<li><a href="Products.jsp">Products</a></li>
				<li><a href="contact.jsp">Contact</a></li>		
		</ul>
		<form action="SearchServlet" method="post">
			
				<input type="text" name="search"> <input
					type="submit" value="Search" id="searchbtn">
			</form>
		</div>
	</div>
	
	<div id="body">
		<div id="products">
			<center><h1>Search Results</h1>
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
							</tr><%}}%>
					</table></center>
		</div>
	</div>
			<div id="body">		<div id="figure">
		<a href="Products.jsp"><img src="images/bed.jpg" alt="Image"></a><a href="Products.jsp"><img src="images/dining.jpg" alt="Image"></a>
		</div></div>
	</body>
</html>