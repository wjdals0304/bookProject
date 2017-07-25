package book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import book.UserService.UserService;
import book.UserService.UserServiceLogic;
import book.domain.Book;
import book.domain.Comment;
import book.domain.Member;

@WebServlet("/comment/create")
public class CommentCreateServlet extends HttpServlet {

	private static final long serialVersionUID = -8485943342342554968L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String bookId = req.getParameter("bookId");
		String contents = req.getParameter("comment");
		String gpa = req.getParameter("gpa");

		if (req.getSession().getAttribute("member") != null) {
			
			Book book = new Book();
			book.setBookId(bookId);
			
			Member member = (Member) req.getSession().getAttribute("member");
			
			int gpa2 = Integer.parseInt(gpa);
			
			String loginId = member.getLoginId();
			
			Comment comment = new Comment();
			comment.setContents(contents);
			comment.setGpa(gpa2);
			comment.setBookId(bookId);
			comment.setLoginId(loginId);
			
			UserService userService = new UserServiceLogic();
			userService.registerComment(comment);
		}
		
		resp.sendRedirect("/bookMarket/book/detail?bookId=" + bookId+"#comment_write");
	}
}
