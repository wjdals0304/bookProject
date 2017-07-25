package book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.UserService.UserService;
import book.UserService.UserServiceLogic;

@WebServlet("/comment/delete")
public class CommentDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = -5235868548288598377L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String commentId = req.getParameter("commentId");
		String bookId = req.getParameter("bookId");
		
		UserService userService = new UserServiceLogic();
		userService.removeComment(commentId);
		
		resp.sendRedirect("/bookMarket/book/detail?bookId=" + bookId+"#comment_list");
	}
}
