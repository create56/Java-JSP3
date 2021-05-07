package login.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionLogin
 */
@WebServlet("/session/login")
public class SessionLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자가 입력한 아이디
		String id = request.getParameter("id");
		// 사용자가 입력한 비밀번호
		String pw = request.getParameter("pw");
		
		// 회원가입 되어있는 사용자의 아이디
		String userID = "id";
		// 회원가입 되어있는 사용자의 비밀번호
		String userPW = "pw";
		//회원가입 되어있는 사용자의 닉네임
		String NickName = "사용자";
		
		if(id.equals(userID) && pw.equals(userPW)) {
			// 세션에 isLogin=true로 저장 ->로그인이 되어있다는 의미
			// 세션에 nickname=회원가입되어있는 사용자의 닉네임 ->현재로그인한 사용자의 닉네임을 저장
			HttpSession session = request.getSession();
			
			session.setAttribute("isLogin", true);
			session.setAttribute("nickname", NickName);
		} else {
			response.setStatus(400);
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
