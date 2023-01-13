import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/createaccountservlet")
public class Createaccount extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		int balance=Integer.parseInt(req.getParameter("amt"));
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/creditdebit","root", "root");
		PreparedStatement pstm=con.prepareStatement("insert into creditdebit(balance,name,age,username,password) values(?,?,?,?,?)");
		
		pstm.setInt(1,balance );
		pstm.setString(2,name);
		pstm.setInt(3, age);
		pstm.setString(4, username);
		pstm.setString(5, password);
		int i=pstm.executeUpdate();
		resp.sendRedirect("LoginPage.jsp");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
