package net.ruangtedy.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ruangtedy.ejb.Salutation;

@WebServlet(value="/salutation", name="salutation-test")
public class SalutationServlet extends HttpServlet{

	@EJB
	private Salutation salutation;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String hy=salutation.getFormalSalutation("Tedy");
		resp.getWriter().println(hy);
		
	}
	
	
}
