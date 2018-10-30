
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	public ReservationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		String s1 = request.getParameter("user_title");
		String s2 = request.getParameter("user_name");
		String s3 = request.getParameter("user_dob");
		String s4 = request.getParameter("user_phone");
		String s5 = request.getParameter("user_email");
		String s6 = request.getParameter("user_address");
		String s7 = request.getParameter("user_gender");
		String s8 = request.getParameter("user_fare");
		String s9 = request.getParameter("user_airlines");
		String s10 = request.getParameter("user_departure");
		String s11 = request.getParameter("user_destination");
		String s12 = request.getParameter("user_departure_date");
		String s13 = request.getParameter("user_departure_time");
		String s14 = request.getParameter("user_return_date");
		String s15 = request.getParameter("user_return_time");
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "1234");

			st = con.createStatement();

			int result = st.executeUpdate("insert into reservation values('" + s1 + "','" + s2 + "','" + s3 + "','" + s4
					+ "','" + s5 + "','" + s6 + "','" + s7 + "','" + s8 + "','" + s9 + "','" + s10 + "','" + s11 + "','"
					+ s12 + "','" + s13 + "','" + s14 + "','" + s15 + "')");
			if (result == 1) {
				RequestDispatcher rd = request.getRequestDispatcher("JourneyDetails.jsp");
				rd.forward(request, response);
			} else {
				out.print("Reservation unsuccessful");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
