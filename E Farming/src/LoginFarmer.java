

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
import javax.servlet.http.HttpSession;


public class LoginFarmer extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String user=request.getParameter("uname");
		String pwd1=request.getParameter("pwd");
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abu","qwerty12345");
		PreparedStatement ps=conn.prepareStatement("select * from farmer where username_mobile=? and password=? ");

		ps.setString(1,user);
		ps.setString(2,pwd1);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) 
		{
		out.println("login success || ");
		HttpSession session=request.getSession(	true);
		out.println("<br>");
		out.print("Welcome Mr:"+rs.getString(3));
		request.getRequestDispatcher("sellproduct.jsp").include(request, response);
		}

		else 
		{
		out.println("login failed....Please Register first");
		request.getRequestDispatcher("Register.html").include(request, response);
		

		}
		}
		catch(Exception e)
		{

		out.println(e);

		}

		}

}

	

