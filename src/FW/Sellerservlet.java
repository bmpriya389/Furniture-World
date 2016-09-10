package FW;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sellerservlet
 */
@WebServlet("/Sellerservlet")
public class Sellerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sellerservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public boolean parseWithFallback(String text) {
		try {
		  Integer.parseInt(text);
		  return true;
		} catch (NumberFormatException e) {
		 return false;
		 } 
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		authDAO_signup AD=new authDAO_signup();
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Signup.jsp");
		PrintWriter out= response.getWriter();
		
		if(request.getParameter("Signup").equals("Register"))
		{
				String companyname=(String)request.getParameter("cname");
				String username=(String)request.getParameter("uname");
				String password=(String)request.getParameter("pwd");
				String cpassword=(String)request.getParameter("cpwd");
				String emailid=(String)request.getParameter("email");
				String address=(String)request.getParameter("address");
				String phoneno=(String)request.getParameter("phone");
				String paypaluname=(String)request.getParameter("paypalacct");
				System.out.println("ttttttttttttttttttt");
				//System.out.println("companyname:"+companyname);
				//System.out.println("username:"+username);
				/*System.out.println("password:"+password);
				System.out.println("cpassword:"+cpassword);
				System.out.println("emailid:"+emailid);
				System.out.println("address:"+address);
				System.out.println("phoneno:"+phoneno);
				System.out.println("paypaluname:"+paypaluname);*/
				if (companyname.length()==0)
				{
					out.println("<b> <font color='red'>Please enter company Name</font></b><p>");
					rd.include(request, response);
				}

				else if (username.length()==0)
				{
					out.println("<b> <font color='red'> Username is missing</font></b><p>");
					rd.include(request, response);
				}
				else if (password.length()==0)
				{
					out.println("<b> <font color='red'> Password is missing</font></b><p>");
					rd.include(request, response);
				}
				else if (cpassword.length()==0)
				{
					out.println("<b> <font color='red'>Please confirm password</font></b><p>");
					rd.include(request, response);
					
				}
				/*else if (cpassword==password)
				{
					out.println("<b> <font color='red'>Mismatch password/confirm password</font></b><p>");
					rd.include(request,
					. response);
					
				}*/
				else if (address.length()==0)
				{
					out.println("<b> <font color='red'>Please enter the address</font></b><p>");
					rd.include(request, response);
					
				}
				else if (phoneno.length()==0)
				{
					out.println("<b> <font color='red'>Please enter the phone number</font></b><p>");
					rd.include(request, response);
					
				}

				else if (!parseWithFallback(phoneno))
				{
					out.println("<b> <font color='red'>Please enter valid phone number</font></b><p>");
					rd.include(request, response);
					
				}
				else if (emailid.length()==0)
				{
					out.println("<b> <font color='red'>Please enter the email address</font></b><p>");
					rd.include(request, response);
					
				}
				else if (paypaluname.length()==0)
				{
					out.println("<b> <font color='red'>Please enter PayPal Account no.</font></b><p>");
					rd.include(request, response);
					
				}
				
					else {
					

						String usertype="S";
						AD.sellersignup(username,companyname,emailid,address,phoneno,paypaluname,password,usertype);
						//out.println("<b> <font color='red size=16>You are registered successfully</font></b><p>");
						rd.include(request, response);

				}
		}

	}

}
