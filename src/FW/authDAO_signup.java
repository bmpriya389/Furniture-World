/**
 * 
 */
package FW;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.lang.model.util.Types;

import com.mysql.jdbc.Statement;



/**
 * @author TEJAS
 *
 */
public class authDAO_signup {
	private static Connection connection = null;
	private static PreparedStatement ps = null;
	boolean logged;

	public String login(String uname,String pass){
		String utype=" ";
		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {}

		try{
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/furniture_world?user=root&password=tejas@13");
			String query="select * from user where uname="+"'"+uname+"'";
			ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery(query);
			String pwd="";
			String username=null;
			while (rs.next()) {
				pwd = rs.getString("pass");
				username = rs.getString("uname");
				utype = rs.getString("utype");
			}
			if(pass.matches(pwd)){
				System.out.println("Username: "+username);
				logged=true;
			}
			else
				logged=false;
		}
		catch(Exception e){System.err.println(e);}
		if (logged)
			return utype;
		else
			return " ";

	}

	public void sellersignup(String un,String cn,String eid,String add,String phn,String pun,String pass,String utype){
		String username=un;
		String companyname=cn;
		String emailid=eid;
		String address=add;
		String phoneno=phn;
		String paypaluname=pun;
		String password=pass;
		String usertype=utype;
		/*System.out.println("dao:"+username);
			System.out.println("companyname:"+companyname);
			System.out.println("emailid:"+emailid);
			System.out.println("address:"+address);
			System.out.println("phoneno:"+phoneno);
			System.out.println("paypaluname:"+paypaluname);*/
		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {}

		try{
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/furniture_world?user=root&password=tejas@13");
			String query="insert into seller values('"+username+"','"+companyname+"','"+emailid+"','"+address+"','"+phoneno+"','"+paypaluname+"');";
			String query1="insert into user values('"+username+"','"+password+"','"+usertype+"')";
			System.out.println("Query:"+query1);
			ps = connection.prepareStatement(query1);
			ps.executeUpdate();
			ps = connection.prepareStatement(query);
			ps.executeUpdate();
			System.out.println("Record inserted successfully");
		}
		catch(Exception e){System.err.println(e);}

	}
	public void buyersignup(String un,String fn,String mn,String ln,String eid,String add,String phn,String pass,String utype){
		String username=un;
		String firstname=fn;
		String middlename=mn;
		String lastname=ln;
		String emailid=eid;
		String address=add;
		String phoneno=phn;
		String password=pass;
		String usertype=utype;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {}

		try{
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/furniture_world?user=root&password=tejas@13");
			String query="insert into buyer values('"+username+"','"+firstname+"','"+middlename+"','"+lastname+"','"+emailid+"','"+address+"','"+phoneno+"');";
			String query1="insert into user values('"+username+"','"+password+"','"+usertype+"')";
			System.out.println("Query:"+query1);
			ps = connection.prepareStatement(query);
			ps.executeUpdate();
			ps = connection.prepareStatement(query1);
			ps.executeUpdate();
			System.out.println("Record inserted successfully");
		}
		catch(Exception e){System.err.println(e);}
	}
	public List prodname(String lr){
		List<Product> product=new ArrayList<Product>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {}

		try{
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/furniture_world?user=root&password=tejas@13");
			String queryall= "select p.productid,p.productname,p.description,p.price,p.companyname,p.quantity,p.dname,p.imagepath from product p";
			String query="select p.productid,p.productname,p.description,p.price,p.companyname,p.quantity,p.dname,p.imagepath from product p inner join department d on p.dname=d.dname where d.dname='"+lr+"'";
			ps = connection.prepareStatement(query);
			
			ResultSet rs;
			if(lr.equals("All"))
			rs = ps.executeQuery(queryall);
			else
			rs = ps.executeQuery(query);
			while (rs.next()) {
				Product productentry=new Product();
				productentry.setProductid(rs.getInt("productid"));
				productentry.setProductname(rs.getString("productname"));
				productentry.setDescription(rs.getString("description"));
				productentry.setPrice(rs.getFloat("price"));
				productentry.setCompanyname(rs.getString("companyname"));
				productentry.setQuantity(rs.getInt("quantity"));
				productentry.setDname(rs.getString("dname"));
				productentry.setImagepath(rs.getString("imagepath"));
				product.add(productentry);

			}
		}
		catch(Exception e){System.err.println(e);}
		return product;
	}

	public List sellerProducts(String companyname){
		List<Product> product=new ArrayList<Product>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {}

		try{
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/furniture_world?user=root&password=tejas@13");
			String query="select p.productid,p.productname,p.description,p.price,p.companyname,p.quantity,p.dname,p.imagepath from product p where p.companyname='"+companyname+"'";
			System.out.println(query);
			ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery(query);
			while (rs.next()) {
				Product productentry=new Product();
				productentry.setProductid(rs.getInt("productid"));
				productentry.setProductname(rs.getString("productname"));
				productentry.setDescription(rs.getString("description"));
				productentry.setPrice(rs.getFloat("price"));
				productentry.setCompanyname(rs.getString("companyname"));
				productentry.setQuantity(rs.getInt("quantity"));
				productentry.setDname(rs.getString("dname"));
				productentry.setImagepath(rs.getString("imagepath"));
				product.add(productentry);

			}
		}
		catch(Exception e){System.err.println(e);}
		return product;
	}

	@SuppressWarnings("rawtypes")
	public List<CartItems> retrieveCart(String uname){
		List<CartItems> cart=new ArrayList();

		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {}

		try{
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/furniture_world?user=root&password=tejas@13");

			String query="select distinct uname,sc.cartid,sc.dateadded,sc.productid,sc.quantity,p.companyname,p.description,p.price,p.productname from buyercart inner join shoppingcart sc inner join product p where uname='"+uname+"' and sc.productid=p.productid and buyercart.cartid=sc.cartid";

			ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery(query);
			while (rs.next()) {
				CartItems cartentry=new CartItems();
				cartentry.setCartid(rs.getInt("cartid"));
				cartentry.setProductid(rs.getInt("productid"));
				cartentry.setQuantity(rs.getInt("quantity"));
				cartentry.setDateadded(rs.getDate("dateadded"));
				cartentry.setProductname(rs.getString("productname"));
				cartentry.setDescription(rs.getString("description"));
				cartentry.setCompanyname(rs.getString("companyname"));
				cartentry.setPrice(rs.getFloat("price"));
				cart.add(cartentry);

			}
		}
		catch(Exception e){System.err.println(e);}
		return cart;
	}
	public int retrieveCartid(String uname){
		int cartid=0;

		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {}

		try{
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/furniture_world?user=root&password=tejas@13");

			String query="select cartid from buyercart where uname='"+uname+"'";

			ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery(query);
			while (rs.next()) {
				cartid=(rs.getInt("cartid"));
			}
		}
		catch(Exception e){System.err.println(e);}
		return cartid;
	}

	public void removeFromCart(int cartid, int productid, int quantity){
		int availablequantity=0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {}

		try{
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/furniture_world?user=root&password=tejas@13");

			String query1="select quantity from product where productid='"+productid+"'";
			ps = connection.prepareStatement(query1);
			ResultSet rs = ps.executeQuery(query1);
			while (rs.next()) {
				availablequantity=(rs.getInt("quantity"));
			}

			availablequantity=availablequantity+quantity;
			String query2="update product set quantity='"+availablequantity+"' where productid='"+productid+"'";

			ps = connection.prepareStatement(query2);
			ps.executeUpdate(query2);
	

			String query3="delete from shoppingcart where cartid='"+cartid+"' and productid='"+productid+"'";

			ps = connection.prepareStatement(query3);
			ps.executeUpdate(query3);

		}

		catch(Exception e){System.err.println(e);}
	}

	@SuppressWarnings("unused")
	public boolean addToCart(int cartid, int productid, int requestedquantity){
		int availablequantity = 0;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String date1= dateFormat.format(date);
		boolean insert=false;
		int existproductid=0;
		int existquantity=0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {}

		try{
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/furniture_world?user=root&password=tejas@13");
			String query1="select quantity from product where productid='"+productid+"'";
			ps = connection.prepareStatement(query1);
			ResultSet rs = ps.executeQuery(query1);
			while (rs.next()) {
				availablequantity=(rs.getInt("quantity"));
			}
			System.out.println("done");
			String query2="select * from shoppingcart where productid='"+productid+"'";
			System.out.println("done2");
			
			ps = connection.prepareStatement(query2);
			ResultSet rs2= ps.executeQuery(query2);
			while (rs2.next()) {
				existproductid=rs2.getInt("productid");
				existquantity=rs2.getInt("quantity");
				existquantity=existquantity+1;
				System.out.println("done3");
			}
			String query4="insert into shoppingcart values("+cartid+","+productid+","+requestedquantity+",'"+date1+"')";
			if(existproductid!=0 && availablequantity>=requestedquantity){
				String query3="update shoppingcart set quantity='"+existquantity+"' where productid='"+productid+"' and cartid='"+cartid+"'";

				ps = connection.prepareStatement(query3);
				ps.executeUpdate(query3);
				insert=true;
				System.out.println("done4");
			}
			else if(availablequantity>=requestedquantity)
			{
				ps = connection.prepareStatement(query4);
				ps.executeUpdate(query4);
				insert=true;
				System.out.println("done5");
			}
			else{
				insert=false;
			}
			if(insert){
				int updateq=availablequantity-requestedquantity;
				String query5="update product set quantity='"+updateq+"' where productid='"+productid+"'";

				ps = connection.prepareStatement(query5);
				ps.executeUpdate(query5);
			}
		}

		catch(Exception e){System.err.println(e);}
	return insert;
	}


	public List<Product> searchItems(String searchstring){
		List<Product> searchlist=new ArrayList();

		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {}

		try{
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/furniture_world?user=root&password=tejas@13");
			String query="select productid,productname,description,price,companyname,quantity,dname,imagepath from product p where productname like '%"+searchstring+"%'";
			ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery(query);
			while (rs.next()) {
				Product product=new Product();
				product.setProductid(rs.getInt("productid"));
				product.setProductname(rs.getString("productname"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getFloat("price"));
				product.setCompanyname(rs.getString("companyname"));
				product.setQuantity(rs.getInt("quantity"));
				product.setDname(rs.getString("dname"));
				product.setImagepath(rs.getString("imagepath"));
				searchlist.add(product);

			}
		}
		catch(Exception e){System.err.println(e);}
		return searchlist;
	}
	public List<Product> sellerSearch(String searchstring, String companyname){
		List<Product> searchlist=new ArrayList();

		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {}

		try{
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/furniture_world?user=root&password=tejas@13");
			String query="select productid,productname,description,price,companyname,quantity,dname,imagepath from product p where productname like '%"+searchstring+"%' and companyname='"+companyname+"'";
			ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery(query);
			while (rs.next()) {
				Product product=new Product();
				product.setProductid(rs.getInt("productid"));
				product.setProductname(rs.getString("productname"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getFloat("price"));
				product.setCompanyname(rs.getString("companyname"));
				product.setQuantity(rs.getInt("quantity"));
				product.setDname(rs.getString("dname"));
				product.setImagepath(rs.getString("imagepath"));
				searchlist.add(product);

			}
		}
		catch(Exception e){System.err.println(e);}
		return searchlist;
	}

	public int getCart(String uname){
		int cartid = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {}

		try{
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/furniture_world?user=root&password=tejas@13");
			String query="select distinct cartid from buyercart where uname='"+uname+"'";
			ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery(query);
			while (rs.next()) {
				cartid=rs.getInt("cartid");
			}
		}
		catch(Exception e){System.err.println(e);}
		return cartid;
	}
	

	public String getCompanyName(String uname){
		String companyName="";
		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {}

		try{
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/furniture_world?user=root&password=tejas@13");
			String query="select companyname from seller where uname='"+uname+"'";
			ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery(query);
			while (rs.next()) 
				companyName=rs.getString("companyname");
		}
		catch(Exception e){System.err.println(e);}
		return companyName;

	}

	public void Sellerupdate(String un,String cn,String eid,String add,String phn,String pay){
		String username=un;
		String companyname=cn;
		String emailid=eid;
		String address=add;
		String phoneno=phn;
		String paypal=pay;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {}

		try{
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/furniture_world?user=root&password=tejas@13");
			String query="update seller set companyname='"+companyname+"',email='"+emailid+"',address='"+address+"',phone='"+phoneno+"',paypal_uname='"+paypal+"' where uname='"+username+"'";
			ps = connection.prepareStatement(query);
			ps.executeUpdate();
			System.out.println("Profile updated successfully");
		}
		catch(Exception e){System.err.println(e);}
	}
	public void Buyerupdate(String un,String fn,String mn,String ln,String eid,String add,String phn){
		String username=un;
		String firstname=fn;
		String middlename=mn;
		String lastname=ln;
		String emailid=eid;
		String address=add;
		String phoneno=phn;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {}

		try{
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/furniture_world?user=root&password=tejas@13");
			String query="update buyer set fname='"+firstname+"',mname='"+middlename+"',lname='"+lastname+"',email='"+emailid+"',address='"+address+"',phone='"+phoneno+"' where uname='"+username+"'";
			System.out.println(query);
			ps = connection.prepareStatement(query);
			ps.executeUpdate();
			System.out.println("Record updated successfully");
		}
		catch(Exception e){System.err.println(e);}
	}


	public List<Order> buyerViewOrder(String uname){
		@SuppressWarnings("rawtypes")
		List<Order> orderslist=new ArrayList();

		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {}

		try{
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/furniture_world?user=root&password=tejas@13");
			String query="select order.orderid, order.orderdate, order.shipdate, order.uname,"
					+ " order.trackingid, order.status, od.productid, od.productname, od.quantity, "
					+ "od.unitprice,sd.saddress, st.stype, st.scost from furniture_world.order "
					+ "inner join  furniture_world.orderdetails od inner join "
					+ "furniture_world.shippingdetails sd inner join furniture_world.shippingtype st "
					+ "where order.uname='"+uname+"'";
			ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery(query);
			while (rs.next()) {
				Order order=new Order();
				order.setOrderid(rs.getInt("orderid"));
				order.setOrderdate(rs.getDate("orderdate"));
				order.setShipdate(rs.getDate("shipdate"));
				order.setUname(rs.getString("uname"));
				order.setTrackingid(rs.getInt("trackingid"));
				order.setStatus(rs.getString("status"));
				order.setProductid(rs.getInt("productid"));
				order.setProductname(rs.getString("productname"));
				order.setQuantity(rs.getInt("quantity"));
				order.setUnitprice(rs.getFloat("unitprice"));
				order.setAddress(rs.getString("saddress"));
				order.setStype(rs.getString("stype"));
				order.setScost(rs.getFloat("scost"));
				
				orderslist.add(order);

			}
		}
		catch(Exception e){System.err.println(e);}
		return orderslist;
	}


	public List<Order> sellerViewOrder(String companyname){
		@SuppressWarnings("rawtypes")
		List<Order> orderslist=new ArrayList();

		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {}

		try{
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/furniture_world?user=root&password=tejas@13");
			String query="select distinct product.companyname, order.orderid, order.orderdate, order.shipdate, order.uname,"
					+ " order.trackingid, order.status, od.productid, od.productname, od.quantity, "
					+ "od.unitprice,sd.saddress, st.stype, st.scost from furniture_world.order "
					+ "inner join  furniture_world.orderdetails od inner join "
					+ "furniture_world.shippingdetails sd inner join furniture_world.shippingtype st inner join product where product.productid=od.productid and product.companyname='"+companyname+"'";
			ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery(query);
			while (rs.next()) {
				Order order=new Order();
				order.setOrderid(rs.getInt("orderid"));
				order.setOrderdate(rs.getDate("orderdate"));
				order.setShipdate(rs.getDate("shipdate"));
				order.setUname(rs.getString("uname"));
				order.setTrackingid(rs.getInt("trackingid"));
				order.setStatus(rs.getString("status"));
				order.setProductid(rs.getInt("productid"));
				order.setProductname(rs.getString("productname"));
				order.setQuantity(rs.getInt("quantity"));
				order.setUnitprice(rs.getFloat("unitprice"));
				order.setAddress(rs.getString("saddress"));
				order.setStype(rs.getString("stype"));
				order.setScost(rs.getFloat("scost"));
				orderslist.add(order);
				System.out.println(query);
			}
		}
		catch(Exception e){System.err.println(e);}
		return orderslist;
	}
	public void selleraddproduct(String pn,String cn,String desc,String cost,String qty,String dept,String imp){
		String prodname=pn;
		String companyname=cn;
		String description=desc;
		String price=cost;
		String quantity=qty;
		String department=dept;
		String imgpath=imp;
		//sSystem.out.println(prodname+companyname+description+price+quantity+department+imgpath);
		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {}

		try{
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/furniture_world?user=root&password=tejas@13");
			//String query="insert into department values('"+department+"','"+description+"')";
			String query="insert into product(productname,description,price,companyname,quantity,dname,imagepath) values('"+prodname+"','"+description+"','"+price+"','"+companyname+"','"+quantity+"','"+department+"','"+imgpath+"')";
			System.out.println(query);
			//System.out.println(query1);
			ps = connection.prepareStatement(query);
			ps.executeUpdate();
			/*ps = connection.prepareStatement(query1);
			ps.executeUpdate();*/
			System.out.println("Product added successfully");
		}
		catch(Exception e){System.err.println(e);}


	}	
}			

