

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


public class ProfileWholeSeller extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		/*response.setContentType("text/jsp");*/
		PrintWriter out=response.getWriter();
		
		String itm=request.getParameter("Item");
		
		
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abu","qwerty12345");
		PreparedStatement ps=conn.prepareStatement(" select * from  farmercart where item=?  ");

	
		ps.setString(1,itm);
		
		
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
		
		out.println("Search Result for  "+itm+"<br><br>");
		out.println("The quantity is "+rs.getInt(2)+"kg  with a per kg price of "+rs.getInt(3)+" rupees <br><br>");
		
		PreparedStatement ps1=conn.prepareStatement(" select * from farmer");
		ResultSet rs1=ps1.executeQuery();
		while(rs1.next())
		{
			out.println("The Seller is   "+rs1.getString(3)+" and his mobile number is "+rs1.getString(1));
		}
		
		
		}

		
		}
		catch(Exception e)
		{

		out.println(e);

		}

		}

}
