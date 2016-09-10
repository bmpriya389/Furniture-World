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
 * Servlet implementation class Selleraddprodservlet
 */
@WebServlet("/Selleraddprodservlet")
public class Selleraddprodservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Selleraddprodservlet() {
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
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/selleraddproduct.jsp");
		PrintWriter out= response.getWriter();
		String productname=request.getParameter("pname");
		String companyname=request.getParameter("cname");
		String productdesc=request.getParameter("desc");
		String price=request.getParameter("price");
		String quantity=request.getParameter("quantity");
		String department=request.getParameter("dept");
		String img=request.getParameter("file");
		
		if (productname.length()==0)
		{
			out.println("<b> <font color='red'>Please enter Product Name</font></b><p>");
			rd.include(request, response);
		}
		else if (companyname.length()==0)
		{
			out.println("<b> <font color='red'>Please enter Company Name</font></b><p>");
			rd.include(request, response);
		}
		else if (productdesc.length()==0)
		{
			out.println("<b> <font color='red'>Please enter Product Description</font></b><p>");
			rd.include(request, response);
		}
		else if (price.length()==0)
		{
			out.println("<b> <font color='red'>Price cannot be blank</font></b><p>");
			rd.include(request, response);
		}
		else if (!parseWithFallback(price))
		{
			out.println("<b> <font color='red'>Price should be numeric</font></b><p>");
			rd.include(request, response);
			
		}
		else if (img.length()==0)
		{
			out.println("<b> <font color='red'>Please select the product image</font></b><p>");
			rd.include(request, response);
		}
		else
		{
		AD.selleraddproduct(productname,companyname,productdesc,price,quantity,department,img);
		rd.include(request, response);
		}
	}

}
