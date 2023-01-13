import java.io.IOException;
import java.io.PrintWriter;
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
import javax.websocket.Session;
@WebServlet("/updateservlet")
public class Updateservlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/creditdebit", "root", "root");
			System.out.println("Connection success");
			
			 
			
			int accountnumber=Integer.parseInt(req.getParameter("accountnumber"));
			
			
			
			
			
			
			
			PreparedStatement pstm=con.prepareStatement("select * from creditdebit where acnumber=?");
			
			
			pstm.setInt(1, accountnumber);
			ResultSet rs=pstm.executeQuery();
			int balance=0;
			while(rs.next())
			{
				balance=rs.getInt("balance");
			}
			
			
			
			int amount=balance;
			String num=req.getParameter("amount");
			 amount+=Integer.parseInt(req.getParameter("amount"));
			 
			
			
			PreparedStatement pstm1=con.prepareStatement("update creditdebit set balance=? where acnumber=?");
			pstm1.setInt(1, amount);
			pstm1.setInt(2, accountnumber);
			int k=pstm1.executeUpdate();
			if(k!=0)
			{
				System.out.println("Balance updated");
				PrintWriter pw=resp.getWriter();
				pw.write("amount credited successfuly");
			}
			else
			{
				System.out.println("error");
			}
			
			String transaction="credited "+num+" rs";
			PreparedStatement pstm2=con.prepareStatement("insert into transactionhistory(acnumber,transaction) values(?,?)");
			pstm2.setInt(1, accountnumber);
			pstm2.setString(2, transaction);
			int j=pstm2.executeUpdate();
			if(j!=0)
			{
				System.out.println("Record transaction updated");
			}
			else
			{
				System.out.println("error");
			}
		} catch (ClassNotFoundException e) 
			// TODO Auto-generated catch block
		{
			e.printStackTrace();
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

