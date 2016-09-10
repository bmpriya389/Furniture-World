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
 * Servlet implementation class AddToCart
 */
@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		authDAO_signup AD=new authDAO_signup();
		int cartid =Integer.parseInt(request.getParameter("param1"));
	    int productid =Integer.parseInt(request.getParameter("param2"));
	    String requestedquantity =(request.getParameter("param3"));
		RequestDispatcher rd=request.getRequestDispatcher("/BuyerProducts.jsp");
	    int requestquantity;
	    if(!requestedquantity.equals("-"))
	    	{
	    	requestquantity=Integer.parseInt(request.getParameter("param3"));	
		    boolean insert = AD.addToCart(cartid,productid,requestquantity);
			if(!insert)
			out.println("<b> <font color='red'>Product is out of stock</font></b><p>");
	    	}
	    
	    
	    rd.forward(request, response);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
