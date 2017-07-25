package book.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.UserService.UserService;
import book.UserService.UserServiceLogic;
import book.bookService.BookService;
import book.bookService.BookServiceLogic;
import book.domain.Book;
import book.domain.BookListPaging;
import book.domain.Comment;
import book.domain.CustomedInfo;
import book.domain.Member;
import book.domain.Order;

@WebServlet("/book/detail")
public class BookDetailServlet extends HttpServlet {
	
	private static final long serialVersionUID = 3592358412838857928L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		
		String bookId = req.getParameter("bookId");

		BookService service = new BookServiceLogic();
		UserService userService = new UserServiceLogic();
		
		List<Comment> commentList = userService.findComment(bookId);
		req.setAttribute("commentList", commentList);

		String index = req.getParameter("index");
		if(index == null) {
			index = "1";
		}
		
		req.setAttribute("index", index);
		
		BookListPaging paging = new BookListPaging();
		
		HashMap<String, Object> map = new HashMap<>();
		
		int num = Integer.parseInt(index);
		paging.setPageNo(num);
		paging.setPageSize(5);
		paging.setTotalCount(commentList.size());
		
		map.put("index", index);
		map.put("pageSize", paging.getPageSize());
		map.put("bookId", bookId);
		
		List<Comment> commentList2 = userService.findCommentForPasing(map);

		req.setAttribute("commentList", commentList2);

		req.setAttribute("paging", paging);
		
		Book book = service.findBook(bookId);

	         long gpa = (long)book.getAllGpa();
	         long gpa2;
	         gpa2 = (gpa*100)/10;
	         book.setAllGpa(gpa2);
	  
		req.setAttribute("book", book);
		
		List<Book> bookList = service.showRecommendedBookList(bookId);
		req.setAttribute("bookList", bookList);
		
		if(req.getSession().getAttribute("member") != null){
			
			Member member = (Member)req.getSession().getAttribute("member");
			
			CustomedInfo customedInfo = new CustomedInfo();
			
			HashMap<String, String> map2 = new HashMap<>();
			map2.put("bookId", bookId);

			String existPurchasedInfo = "F";
			
			List<Order> myOrderList = service.retrieveAllByMemberId(member.getMemberId());
			for ( Order order : myOrderList ) {
				map2.put("orderId", order.getOrderId());

				existPurchasedInfo = service.checkPurchasedInfoIdByOrderIdMemberId(map2);
				
				if ( existPurchasedInfo == "T" ) {
					break;
				}
			}
			
			req.setAttribute("existPurchasedInfo", existPurchasedInfo);
			
			customedInfo.setBook(book);
			customedInfo.setMemberId(member.getMemberId());
		
			service.createCustomedInfo(customedInfo);
		}
		
		req.getRequestDispatcher("/jsp/detailBook.jsp").forward(req, resp);
	}
}
