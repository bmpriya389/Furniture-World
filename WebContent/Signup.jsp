<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Sign Up</title>
<link rel="stylesheet" type="text/css" href="style_index.css">
</head>
<body>
	<div id="header">
		<a href="index.jsp"><img src="images/logo.gif" alt="Image"></a>
		<a href="Login.jsp"><button>Login</button></a> <a href="Signup.jsp"><button>Sign
				Up</button></a>
		
	<div>
			<ul>
				<li><a href="index.jsp">Home</a></li>
				<li><a href="AboutUs.jsp">About</a></li>
				<li><a href="Products.jsp">Products</a></li>
				<li><a href="contact.jsp">Contact</a></li>
					</ul>	<form action="SearchServlet" method="post">
			
				<input type="text" name="search"> <input
					type="submit" value="Search" id="searchbtn">
			</form>
		
		</div>
	</div>

	<div id="body">
	<div><table>
		<tr>
						<div id="products">
		
			<td>
					<center>
						<h1>Seller Sign Up</h1>
					</center>
			<form name=seller action=Sellerservlet method=post>
				<table align=center>
					<tr>
						<td>Company Name</td>
						<td><input type="text" name="cname"></td>
					</tr>
					<tr>
						<td>UserName</td>
						<td><input type="text" name="uname"></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="pwd"></td>
					</tr>
					<tr>
						<td>Re enter Password</td>
						<td><input type="password" name="cpwd"></td>
					</tr>
					<tr>
						<td>Address:</td>
						<td><textarea id="address" name="address" rows=3 cols=20></textarea></td>
					</tr>
					<tr>
						<td>Phone</td>
						<td><input type="text" name="phone"></td>
					</tr>
					<tr>
						<td>Email Address</td>
						<td><input type="text" name="email"></td>
					</tr>
					<tr>
						<td>PayPal Account</td>
						<td><input type="text" name="paypalacct"></td>
					</tr>
					<tr>
						<td colspan=2><center>
								<input type="submit" name="Signup" value="Register">
								
							</center></td>
					</tr>
				</table>
			</form>
				</div>
		   </td>
		   
			<td>
				<div id="products">
				<center>
					<h1>Buyer Sign Up</h1>
				</center>
			<form action=Buyerservlet method="post">
				<table align=center>
					<tr>
						<td>User Name</td>
						<td><input type="text" name="uname"></td>
					</tr>
					<tr>
						<td colspan=2><input type="submit" name="check"
							value="Check Username"></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="pwd"></td>
					</tr>
					<tr>
						<td>Re enter Password</td>
						<td><input type="password" name="cpwd"></td>
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
						<td colspan=2><center>
								<input type="submit" name="Signup" value="SIGNUP">
							</center></td>
					</tr>
				</table>
			</form>
		</div>
		   </td>
		</tr>
	</table>
	</div></div>
	<div id="footer"></div>
</body>
</html>