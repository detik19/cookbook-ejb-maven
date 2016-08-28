package net.ruangtedy.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ruangtedy.ejb.Salutation;

@WebServlet(value="/salutation", name="salutation-test")
public class SalutationServlet extends HttpServlet{


	private Salutation salutation;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Context context=null;
		try {
			context=new InitialContext();
			salutation=(Salutation) context.lookup("java:global/cookbookapp/cookbook-services-0.0.1-SNAPSHOT/Salutation!net.ruangtedy.ejb.Salutation");
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//salutation=context.lookup(name)
				
		String hy=salutation.getFormalSalutation("Tedy");
		resp.getWriter().println(hy);
		
	}
	
	
}
