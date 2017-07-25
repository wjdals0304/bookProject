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

@WebServlet("/introDuce/modify")
public class IntroDuceModifyServlet extends HttpServlet {

	private static final long serialVersionUID = -6428930469266352242L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String introduceId = req.getParameter("introDuceId");
		String introduceRole = req.getParameter("introDuceRole");
		String introduceName = req.getParameter("introDuceName");
		String introduceFunction = req.getParameter("introDuceFunction");
		
		IntroDuce introDuce = new IntroDuce();
		
		introDuce.setIntroDuceId(introduceId);
		introDuce.setRole(introduceRole);
		introDuce.setName(introduceName);
		introDuce.setFunction(introduceFunction);
		
		IntroDuceService introDuceService = new IntroDuceServiceLogic();
		introDuceService.modify(introDuce);
		
		resp.sendRedirect("/bookMarket/introDuce/list");
	}

}
