package login.session;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class SessionLogout
 */
@WebServlet("/session/logout")
public class SessionLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionLogout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		session.setAttribute("isLogin", false);
		session.removeAttribute("nickname");
		
//		RequestDispatcher dis = request.getRequestDispatcher("chapter14/SessionLogin.jsp");
//		dis.forward(request, response);
		//sendRedirect ->포워딩하면 URL이 바꿘다
//		response.sendRedirect("/JSPBook/chapter14/SessionLogin.jsp");
		
		//Location 헤더에 이동해야될 URL을 명시
//		response.addHeader("Location", "/JSPBook/chapter14/SessionLogin.jsp");
		// 응답코드 303코드를 반환
//		response.setStatus(303);
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print("<script>alert(\"로그아웃되었습니다\\n로그인 페이지로 이동합니다.\");location.href='/JSPBook/chapter14/SessionLogin.jsp'</script");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
