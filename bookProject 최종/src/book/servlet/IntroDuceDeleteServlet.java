package book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import introDuce.IntroDuceService;
import introDuce.IntroDuceServiceLogic;

@WebServlet("/introDuce/delete")
public class IntroDuceDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1463390040799120878L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String introDuceId = req.getParameter("introDuceId");
		
		IntroDuceService introDuceService = new IntroDuceServiceLogic();
		introDuceService.delete(introDuceId);
		
		resp.sendRedirect("/bookMarket/introDuce/list");
	}

}
