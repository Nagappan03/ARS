
import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	public LoginServlet() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String s1 = request.getParameter("user_email");
		String s2 = request.getParameter("user_password");
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "1234");

			st = con.createStatement();

			rs = st.executeQuery("select * from registration");

			while (rs.next()) {
				String email = rs.getString("email");
				String pass = rs.getString("password");
				if (email.equals(s1) && pass.equals(s2)) {
					RequestDispatcher rd = request.getRequestDispatcher("Reservation.html");
					rd.forward(request, response);

				}
			}
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
