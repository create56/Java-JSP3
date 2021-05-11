package member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Join
 */
@WebServlet("/member/join")
public class MenberJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenberJoin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		Connection conn = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3307/JSPBookDB?user=root&password=koreait");
			
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO member (id,pw,name) VALUES(?,?,?) ");
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			int row =pstmt.executeUpdate();
			
//			Statement stmt = conn.createStatement();
			
								// INSERT문부터 VALUES 까지가  쿼리 문이고 // ('korea','it','academy')
//			int row = stmt.executeUpdate("INSERT INTO member(id, pw, name) VALUES('"+ id +"', '" + pw +"', '"+ name +"')");
			if(row == 1) {
				//회원가입 성공
				response.setStatus(201);
//	 			response.setStatus(Response.SC_CREATED);
			} else {
				response.setStatus(400);
				// 회원가입 실패
			}
		} catch( SQLException | ClassNotFoundException e) {
			// 예외 처리
			e.printStackTrace();
			response.setStatus(500);
		} finally {
			if(conn != null ) {
				try {
					conn.close();
				} catch(SQLException e) {
					
				}
			}
		}
		
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
