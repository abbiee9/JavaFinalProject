

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


public class ProfileFarmer extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		/*response.setContentType("text/jsp");*/
		PrintWriter out=response.getWriter();
		
		String itm=request.getParameter("Item");
		
		int quantity=Integer.parseInt(request.getParameter("quant"));
		//int quantity=Integer.parseInt(name);
		

		int quote=Integer.parseInt(request.getParameter("rate"));
		
		//int quote=Integer.parseInt(price);
		
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Abu","qwerty12345");
		PreparedStatement ps=conn.prepareStatement(" insert into farmercart values(?,?,?) ");
		
		
	
		ps.setString(1,itm);
		ps.setInt(2,quantity);
		ps.setInt(3,quote);
		
		
		int row=ps.executeUpdate();
		if(row>=1) 
		{
		out.println("Your order been added to cart ,...you will be notified soon ...!! <br><br>");
		PreparedStatement ps1=conn.prepareStatement(" select * from farmercart");
		ResultSet rs=ps1.executeQuery();
		while(rs.next())
		{
			out.println("Item is  "+rs.getString(1)+" and the quantity is "+rs.getInt(2)+" with a per kg price of "+rs.getInt(3));
		}
		/*out.println('<a href="/ProfileFarmer">Continue to add</a>');
		out.println("<a href='/link.html'>Logout</a>");*/
		
		}

		else 
		{
			request.getRequestDispatcher("/profilefarmer").include(request, response);
		out.println("Add again");

		}
		}
		catch(Exception e)
		{

		out.println(e);

		}

		}

}

	

