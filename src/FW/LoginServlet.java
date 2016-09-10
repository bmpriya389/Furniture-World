package FW;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		authDAO_signup AD=new authDAO_signup();
		HttpSession session=request.getSession();
		String user=request.getParameter("uname");
		String password=request.getParameter("pwd");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.jsp");
		PrintWriter out= response.getWriter();
		session.setAttribute("name", user);
		session.setAttribute("loggedIn", false);
		session.setAttribute("utype", AD.login(user, password));

		if (user.length()==0 && password.length()==0)
		{
			out.println("<b> <font color='red'> Username/Password is missing</font></b><p>");
			rd.include(request, response);
		}

		else if (user.length()==0)
		{
			out.println("<b> <font color='red'> Username is missing</font></b><p>");
			rd.include(request, response);
		}
		else if (password.length()==0)
		{
			out.println("<b> <font color='red'> Password is missing</font></b><p>");
			rd.include(request, response);
		}
		else if (user.length()!=0 && password.length()!=0)
		{
			session.setAttribute("loggedIn", "true");
				
			if(AD.login(user, password).equals("B"))
				response.sendRedirect("Buyer.jsp");
			else if(AD.login(user, password).equals("S"))
				response.sendRedirect("Seller.jsp");
			else if(AD.login(user, password).equals("A"))
				response.sendRedirect("Admin.jsp");
			else if(AD.login(user, password).equals(" "))
			{
				out.println("<b> <font color='red'> Username/Password is wrong</font></b><p>");
				rd.include(request, response);
			}

		}
	}
}




