

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


public class RegisterFarmer extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String s=request.getParameter("uname");
		int user=Integer.parseInt(s);
		String pwd1=request.getParameter("pwd");
		String name=request.getParameter("nam");
		String vill=request.getParameter("vil");
		String mand=request.getParameter("man");
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abu","qwerty12345");
		PreparedStatement ps=conn.prepareStatement(" insert into farmer values(?,?,?,?,?) ");

		ps.setInt(1,user);
		ps.setString(2,pwd1);
		ps.setString(3,name);
		ps.setString(4,vill);
		ps.setString(5,mand);
		
		int row=ps.executeUpdate();
		if(row>=1) 
		{
		out.println("Registration succesfull");
		request.getRequestDispatcher("Login.html").include(request, response);
		
		
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

	

