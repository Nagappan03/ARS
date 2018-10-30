<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Journey Details</title>
</head>
<body>
	<h1>JOURNEY DETAILS</h1>
	<%
		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "1234");

		Statement st = con.createStatement();

		ResultSet resultset = st.executeQuery("select * from reservation");
	%>

	<TABLE BORDER="1">
		<TR>
			<TH>Title</TH>
			<TH>Name</TH>
			<TH>DOB</TH>
			<TH>Phone</TH>
			<TH>Email</TH>
			<TH>Address</TH>
			<TH>Gender</TH>
			<TH>Fare</TH>
			<TH>Airlines</TH>
			<TH>Departure</TH>
			<TH>Destination</TH>
			<TH>Departure Date</TH>
			<TH>Departure Time</TH>
			<TH>Return Date</TH>
			<TH>Return Time</TH>
		</TR>
		<%
			while (resultset.next()) {
		%>
		<TR>
			<TD><%=resultset.getString(1)%></td>
			<TD><%=resultset.getString(2)%></TD>
			<TD><%=resultset.getString(3)%></TD>
			<TD><%=resultset.getString(4)%></TD>
			<TD><%=resultset.getString(5)%></TD>
			<TD><%=resultset.getString(6)%></td>
			<TD><%=resultset.getString(7)%></td>
			<TD><%=resultset.getString(8)%></td>
			<TD><%=resultset.getString(9)%></td>
			<TD><%=resultset.getString(10)%></td>
			<TD><%=resultset.getString(11)%></td>
			<TD><%=resultset.getString(12)%></td>
			<TD><%=resultset.getString(13)%></td>
			<TD><%=resultset.getString(14)%></td>
			<TD><%=resultset.getString(15)%></td>
		</TR>
		<%
			}
		%>
	</TABLE>
</body>
</html>