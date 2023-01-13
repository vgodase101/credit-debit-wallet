import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/transactionservlet")
public class Transactionservlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		int accountnumber=Integer.parseInt(req.getParameter("acnumber"));
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/creditdebit", "root", "root");
		System.out.println("Connection success");
		
		PreparedStatement pstm=con.prepareStatement("select * from transactionhistory where acnumber=?");
		pstm.setInt(1, accountnumber);
		ResultSet rs=pstm.executeQuery();
		HttpSession s=req.getSession();
		s.setAttribute("rs", rs);
		resp.sendRedirect("Transaction.jsp");
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
