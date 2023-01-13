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
@WebServlet("/Loginaccount")
public class Loginaccount extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/creditdebit", "root", "root");
		PreparedStatement pstm=con.prepareStatement("select * from creditdebit where username=?");
		pstm.setString(1,username );
		ResultSet rs=pstm.executeQuery();
		String user="";
		String pass="";
		String name="";
		while(rs.next())
		{
			user=rs.getString("username");
			pass=rs.getString("password");
			name=rs.getString("name");
		}
		if(username.equals(user)&&password.equals(pass))
		{
			resp.sendRedirect("Main.jsp");
		HttpSession s	=req.getSession();
		s.setAttribute("nm", name);
		}
		else
		{
			System.out.println("error");
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
