

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class NewServlet extends HttpServlet
{
	String uname,upass;
	String b1,b2,b3;
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException
	{
		b1 = req.getParameter("add");
		
		try
		{
			if(b1!=null)
			{
                            
                              
				uname = req.getParameter("txtName");
				upass = req.getParameter("txtpass");
				Class.forName("org.apache.derby.jdbc.ClientDriver");
				Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
				PreparedStatement stat = con.prepareStatement("Insert   into udetails values(?,?)");
				stat.setString(1,uname);
				stat.setString(2,upass);
                                
				stat.executeUpdate();
				PrintWriter out = res.getWriter();
				
                                out.println("WELOME TO "+uname);
				out.close();
			}			
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}		
	}
}
