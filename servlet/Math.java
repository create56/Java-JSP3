package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Math
 */
@WebServlet("/math")
public class Math extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Math() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String math1 = request.getParameter("math1");
		String math2 = request.getParameter("math2");
		
		int math1_i= Integer.parseInt(math1);
		int math2_i = Integer.parseInt(math2);
		
		int plus = math1_i + math2_i;
		int minus = math1_i - math2_i;
		int div = math1_i  / math2_i;
		int mul = math1_i * math2_i;
		
		request.setAttribute("plus", plus);
		request.setAttribute("minus", minus);
		request.setAttribute("div", div);
		request.setAttribute("mul", mul); //제어를 JSP로 넘겨주기 위해 setAttribute를 쓴다.
		
		RequestDispatcher dis = request.getRequestDispatcher("/calcResult.jsp");
		dis.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
