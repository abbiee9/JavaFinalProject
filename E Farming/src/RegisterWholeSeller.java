

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterWholeSeller extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String user=request.getParameter("uname");
		String pwd1=request.getParameter("pwd");
		String Adhar=request.getParameter("aadhar");
		String name=request.getParameter("nam");
		String cty=request.getParameter("city");
		String shop=request.getParameter("shop_a");
		String m=request.getParameter("mobile");
		int mob=Integer.parseInt(m);
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abu","qwerty12345");
		PreparedStatement ps=conn.prepareStatement(" insert into wholeseller values(?,?,?,?,?,?,?) ");

		ps.setString(1,user);
		ps.setString(2,pwd1);
		ps.setString(3,Adhar);
		ps.setString(4,name);
		ps.setString(5,cty);
		ps.setString(6,shop);
		ps.setInt(7,mob);
		
		
		int row=ps.executeUpdate();
		if(row>=1) 
		{
		out.println("Registration succesfull as a Wholeseller");
		request.getRequestDispatcher("Login1.html").include(request, response);
		
		}

		else 
		{
		out.println("failed");

		}
		}
		catch(Exception e)
		{

		out.println(e);

		}

		}

}

	

