package login.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/cookie/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원가입 되어있는 사용자의 아이디
		String userID = "user";
		// 회원가입 되어있는 사용자의 비밀번호
		String userPW = "pw";
		// 회원가입 되어있는 사용자의 닉네임
		String userNickName = "사용자";
		
		// 사용자가 전달한 id
		String id = request.getParameter("id");
		
		// 사용자가 전달한 pw
		String pw = request.getParameter("pw");
		
		// 회원가입 되어있는 아이디와 비밀번호를
		// 사용자가 보낸 (전달한)아이디화 비밀번호를 비교해서
		// 같다면
		// 1.아이디 , 비밀번호, 닉네임(userNickName)을 저장하는 쿠키 생성
		if(id.equals(userID) && pw.equals(userPW)) {
			Cookie cookie1  = new Cookie("ID",id);
			Cookie cookie2  = new Cookie("PW",pw);
			Cookie cookie3  = new Cookie("NickName",userNickName);
		// 2.클라이언트로 쿠키 전달
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			response.addCookie(cookie3);
		// 3.200 응답 코드
			response.setStatus(200);
		// 다르다면
		// 4.400번대 응답코드
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
