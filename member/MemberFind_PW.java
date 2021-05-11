package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberFind_PW
 */
@WebServlet("/member/find_pw")
public class MemberFind_PW extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFind_PW() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		Connection conn = null;
		
		try {
		Class.forName("org.mariadb.jdbc.Driver");
		
		conn = DriverManager.getConnection("jdbc:mariadb://localhost:3307/JSPBookDB?user=root&password=koreait");
		
		PreparedStatement pstmt = conn.prepareStatement("SELECT pw FROM member WHERE id=? AND name=?");
		pstmt.setString(1, id);
		pstmt.setString(2, name);
		
		ResultSet rs = pstmt.executeQuery();
//		Statement stmt = conn.createStatement();
		
//		ResultSet rs = stmt.executeQuery("SELECT pw FROM member WHERE id = '" + id +"' AND name = '"+ name + "'");
		boolean isExist = rs.next();
		
		if(isExist) {
			String pw = rs.getString("pw");
			PrintWriter out = response.getWriter();
			
			out.print(pw);
			
			response.setStatus(200);
		} else {
			response.setStatus(400);
		}
			
		} catch(Exception e) {
			e.printStackTrace();
			response.setStatus(500);
		} finally {
			if(conn != null) {
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
