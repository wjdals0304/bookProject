package book.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import book.bookService.BookService;
import book.bookService.BookServiceLogic;
import book.domain.Book;
import book.domain.Category;
import book.domain.CustomedInfo;
import book.domain.Member;

@WebServlet("/book/main")
public class BookMainServlet extends HttpServlet {

	private static final long serialVersionUID = 2381415984765910166L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		BookService service = new BookServiceLogic();

		List<Category> categoryList = service.retrieveAll();

		HttpSession session = req.getSession();
		session.setAttribute("category", categoryList);

		List<Book> newBookList = service.showNewBookList();
		req.setAttribute("newBookList", newBookList);

		  if(service.showBestSellerList() != null){
		         List<Book> bestSellerList = service.showBestSellerList();
		         req.setAttribute("bestSellerList", bestSellerList);
		      }

		if (req.getSession().getAttribute("member") != null) {

			Member member = (Member) req.getSession().getAttribute("member");
			CustomedInfo customedInfo = service.retrieveByMemberId(member.getMemberId());
			
			if (customedInfo != null) {
				
				List<Book> customedBookList = service.showCustomedBookList(member.getMemberId());

				req.setAttribute("customedBookList", customedBookList);
				
			}
		}
		req.getRequestDispatcher("/jsp/main.jsp").forward(req, resp);

	}

}