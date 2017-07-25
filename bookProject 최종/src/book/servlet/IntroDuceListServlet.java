package book.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import introDuce.IntroDuce;
import introDuce.IntroDuceService;
import introDuce.IntroDuceServiceLogic;

@WebServlet("/introDuce/list")
public class IntroDuceListServlet extends HttpServlet {
	//
	private static final long serialVersionUID = -2586247051692983927L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		
		IntroDuceService introDuceService = new IntroDuceServiceLogic();
		List<IntroDuce> introDuce = introDuceService.findAllList();
		
		req.setAttribute("intro", introDuce);
		
		req.getRequestDispatcher("/jsp/memberintroduction.jsp").forward(req, resp);
	}

}
