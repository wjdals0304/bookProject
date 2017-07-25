package book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import introDuce.IntroDuceService;
import introDuce.IntroDuceServiceLogic;

@WebServlet("/introDuce/submodify")
public class IntroDuceModifySubServlet extends HttpServlet {

	private static final long serialVersionUID = -554038821607805209L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String introDuceId = req.getParameter("introDuceId");
		String introDuceRole = req.getParameter("introDuceRole");
		String introDuceName = req.getParameter("introDuceName");
		String introDuceFunction = req.getParameter("introDuceFunction");
		
		req.setAttribute("intro", introDuceId);
		req.setAttribute("introDuceRole", introDuceRole);
		req.setAttribute("introDuceName", introDuceName);
		req.setAttribute("introDuceFunction", introDuceFunction);
		
		req.getRequestDispatcher("/jsp/modify.jsp").forward(req, resp);
	}
}
