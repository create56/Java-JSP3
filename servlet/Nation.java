package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Nation
 */
@WebServlet("/nation")
public class Nation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Nation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nation = request.getParameter("nation");
		
		if(nation.equals("ko")) {
			//�ѱ��� �λ縻�� ����ϴ� �������� �̵� �Ǵ� �������� ���	
			RequestDispatcher dis = request.getRequestDispatcher("hellp_ko.jsp");
			dis.forward(request, response);
		} else if(nation.equals("ch")) {
			//�߱��� �λ縻�� ����ϴ� �������� �̵� �Ǵ� �������� ���
			RequestDispatcher dis = request.getRequestDispatcher("hellp_ko.jsp");
			dis.forward(request, response);
	
		} else if(nation.equals("ja")) {
			//�Ϻ��� �λ縻�� ����ϴ� �������� �̵� �Ǵ� �������� ���
			RequestDispatcher dis = request.getRequestDispatcher("hellp_ko.jsp");
			dis.forward(request, response);
		} else if(nation.equals("am")) {
			//���� �λ縻�� ����ϴ� �������� �̵� �Ǵ� �������� ���	
			RequestDispatcher dis = request.getRequestDispatcher("hellp_ko.jsp");
			dis.forward(request, response);
		} else {
			//�ٸ� �λ縻��
			RequestDispatcher dis = request.getRequestDispatcher("hellp_ko.jsp");
			dis.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}