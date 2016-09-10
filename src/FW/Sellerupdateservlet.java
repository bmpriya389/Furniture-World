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
 * Servlet implementation class Sellerupdateservlet
 */
@WebServlet("/Sellerupdateservlet")
public class Sellerupdateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sellerupdateservlet() {
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
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/sellerupdate.jsp");
		PrintWriter out= response.getWriter();
		String username=(String)request.getParameter("uname");
		String companyname=(String)request.getParameter("cname");
		String emailid=(String)request.getParameter("email");
		String address=(String)request.getParameter("address");
		String phoneno=(String)request.getParameter("phone");
		String paypal=(String)request.getParameter("paypalacct");
		
		if (username.length()==0)
		{
			out.println("<b> <font color='red'> Username is missing</font></b><p>");
			rd.include(request, response);
		}
		else if (companyname.length()==0)
		{
			out.println("<b> <font color='red'>Please enter company Name</font></b><p>");
			rd.include(request, response);
		}
		else if (address.length()==0)
		{
			out.println("<b> <font color='red'>Please enter the address</font></b><p>");
			rd.include(request, response);
			
		}
		else if (phoneno.length()==0)
		{
			out.println("<b> <font color='red'>Please enter phone number</font></b><p>");
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
		else if (paypal.length()==0)
		{
			out.println("<b> <font color='red'>Please enter PayPal Account no.</font></b><p>");
			rd.include(request, response);
			
			
		}
		else
		{
		AD.Sellerupdate(username,companyname,emailid,address,phoneno,paypal);
		rd.include(request, response);
		
		}
	}

}
