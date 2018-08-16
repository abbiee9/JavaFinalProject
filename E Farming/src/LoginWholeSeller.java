

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


public class LoginWholeSeller extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String user1=request.getParameter("uname1");
		String pwd11=request.getParameter("pwd12");
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abu","qwerty12345");
		PreparedStatement ps=conn.prepareStatement("select * from wholeseller where username=? and password=? ");

		ps.setString(1,user1);
		ps.setString(2,pwd11);
		ResultSet rs1=ps.executeQuery();
		
		if(rs1.next()) 
		{
		out.println("login success");
		HttpSession session=request.getSession(	true);
		out.println("<br>");
		out.print("Welcome Mr:"+rs1.getString(4));
		request.getRequestDispatcher("buyproduct.jsp").include(request, response);
		
		}

		else 
		{
		out.println("login failed....Please Register first");
		request.getRequestDispatcher("Register1.html").include(request, response);

		}
		}
		catch(Exception e)
		{

		out.println(e);

		}

		}

}

	

