package book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import introDuce.IntroDuce;
import introDuce.IntroDuceService;
import introDuce.IntroDuceServiceLogic;

@WebServlet("/introDuce/create")
public class IntroDuceCreateServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3578480068726549901L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String role = req.getParameter("role");
		String name = req.getParameter("name");
		String function = req.getParameter("function");
		
		IntroDuce introDuce = new IntroDuce(role, name, function);
		
		IntroDuceService introDuceService = new IntroDuceServiceLogic();
		introDuceService.create(introDuce);
		
		resp.sendRedirect("/bookMarket/introDuce/list");
		
	}
}