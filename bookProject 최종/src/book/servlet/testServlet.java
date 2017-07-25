package book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/test")
public class testServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1596429775431807817L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String age= req.getParameter("age");
		
		System.out.println("name : "+name);
		System.out.println("age  :" +age);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		String age= req.getParameter("age");
		
		System.out.println("Post name : "+name);
		System.out.println("Post age  :" +age);
	}
	
	
}
