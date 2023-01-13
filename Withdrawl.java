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
@WebServlet("/Withdrawlservlet")
public class Withdrawl extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int accountnumber=Integer.parseInt(req.getParameter("acnumber"));
	int witamount=Integer.parseInt(req.getParameter("amount"));
	String num=req.getParameter("amount");
	try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/creditdebit", "root","root");
		System.out.println("Connection success");
		
		PreparedStatement pstm=con.prepareStatement("select * from creditdebit where acnumber=?");
		pstm.setInt(1, accountnumber);
	ResultSet rs	=pstm.executeQuery();
	int balance=0;
	
	while(rs.next())
	{
		balance=rs.getInt("balance");
	}
		balance=balance-witamount;
	PrintWriter pw	=resp.getWriter();
	pw.write("successfully withdrawl.Your current balance is:"+balance);
	
PreparedStatement pstm1=con.prepareStatement("update creditdebit set balance=? where acnumber=?");
pstm1.setInt(1, balance);
pstm1.setInt(2, accountnumber);
int i=pstm1.executeUpdate();
if(i!=0)
{
	System.out.println("successfully run");
}
else
{
	System.out.println("error");
}
String transaction="Debited "+num+" rs";

PreparedStatement pstm2=con.prepareStatement("insert into transactionhistory(acnumber,transaction) values(?,?)");
pstm2.setInt(1, accountnumber);
pstm2.setString(2, transaction);
int j=pstm2.executeUpdate();
if(j!=0)
{
	System.out.println("transaction history updated");
}
else
{
	System.out.println("error");
}

	con.close();
	} catch (ClassNotFoundException e) {
		
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
