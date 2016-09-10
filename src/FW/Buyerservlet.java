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
 * Servlet implementation class Buyerservlet
 */
@WebServlet("/Buyerservlet")
public class Buyerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Buyerservlet() {
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
		System.out.print("dddddddddddddddddddddddddddddddd'");
		authDAO AD=new authDAO();
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Signup.jsp");
		PrintWriter out= response.getWriter();
		String username=(String)request.getParameter("uname");
		String password=(String)request.getParameter("pwd");
		String cpassword=(String)request.getParameter("cpwd");
		String firstname=(String)request.getParameter("fname");
		String middlename=(String)request.getParameter("mname");
		String lastname=(String)request.getParameter("lname");
		String emailid=(String)request.getParameter("email");
		String address=(String)request.getParameter("address");
		String phoneno=(String)request.getParameter("phone");
		String usertype="B";
		if (username.length()==0)
		{
			out.println("<b> <font color='red'>Username cannot be blank</font></b><p>");
			rd.include(request, response);
		}
		else if (password.length()==0)
		{
			out.println("<b> <font color='red'>Password cannot be blank</font></b><p>");
			rd.include(request, response);
		}
		else if (cpassword.length()==0)
		{
			out.println("<b> <font color='red'>Please confirm the password</font></b><p>");
			rd.include(request, response);
		}
		/*else if (password!=cpassword)
		{
			out.println("<b> <font color='red'>Password/Confrim password mismatch</b><p>");
			rd.include(request, response);
		}*/
		else if (firstname.length()==0)
		{
			out.println("<b> <font color='red'>Please enter the first name</font></b><p>");
			rd.include(request, response);
		}
		else if (lastname.length()==0)
		{
			out.println("<b> <font color='red'>Please enter the last name</font></b><p>");
			rd.include(request, response);
		}
		
		else if (address.length()==0)
		{
			out.println("<b> <font color='red'>Please enter the address</font></b><p>");
			rd.include(request, response);
		}
		else if (phoneno.length()==0)
		{
			out.println("<b> <font color='red'>Phone number cannot be blank</font></b><p>");
			rd.include(request, response);
		}
		else if (!parseWithFallback(phoneno))
		{
			out.println("<b> <font color='red'>Please enter valid phone number</font></b><p>");
			rd.include(request, response);
			
		}
		else if (emailid.length()==0)
		{
			out.println("<b> <font color='red'>Email address cannot be blank</font></b><p>");
			rd.include(request, response);
		}
		else
		AD.buyersignup(username,firstname,middlename,lastname,emailid,address,phoneno,password,usertype);
		rd.include(request, response);
		}
	}


