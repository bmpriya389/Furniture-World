package FW;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SellerSearchServlet")
public class SellerSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerSearchServlet() {
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
		String searchstring=request.getParameter("search");
		HttpSession session=request.getSession();
		System.out.println(searchstring);
		List<Product> searchlist=new ArrayList<Product>();
		authDAO_signup AD=new authDAO_signup();
		RequestDispatcher rd =request.getRequestDispatcher("SellerSearchPage.jsp");
		String uname =(String) session.getAttribute("name");
		String companyName=AD.getCompanyName(uname);
		searchlist=AD.sellerSearch(searchstring,companyName);
		request.setAttribute("searchlist", searchlist);
		rd.include(request, response);

	}

}
