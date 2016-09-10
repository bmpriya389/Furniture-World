/**
 * 
 */
package FW;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;



/**
 * @author TEJAS
 *
 */
public class authDAO {
	private static Connection connection = null;
		private static PreparedStatement ps = null;
		
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
				ps = connection.prepareStatement(query);
				ps.executeUpdate();
				ps = connection.prepareStatement(query1);
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
}


