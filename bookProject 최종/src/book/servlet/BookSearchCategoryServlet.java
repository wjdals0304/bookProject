package book.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.bookService.BookService;
import book.bookService.BookServiceLogic;
import book.domain.Book;
import book.domain.BookListPaging;
@WebServlet("/search/category")
public class BookSearchCategoryServlet extends HttpServlet {
	//
	private static final long serialVersionUID = 867953175901687417L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		String categoryId = req.getParameter("categoryId");
		HashMap<String, Object> map = new HashMap<>();
		List<Book> list = new ArrayList<>();
		List<Book> list2 = new ArrayList<>();
		BookService dao = new BookServiceLogic();
		
		list = dao.retrieveAllBookByCategory(categoryId);
		
		String index = req.getParameter("index");
		if(index == null) {
			index = "1";
		}
		req.setAttribute("index", index);
		
		BookListPaging paging = new BookListPaging();
		
		int num = Integer.parseInt(index);
		paging.setPageNo(num);
		paging.setPageSize(5);
		paging.setTotalCount(list.size());
		
		map.put("index", index);
		map.put("categoryId", categoryId);
		map.put("pageSize", paging.getPageSize());
		
		list2 = dao.retrieveAllBookByCategoryPaging(map);
		
		for(Book book : list2) {
			long gpa = (long)book.getAllGpa();
			long gpa2;
			gpa2 = (gpa*100)/10;
			book.setAllGpa(gpa2);
		}
		
		req.setAttribute("list", list);
		req.setAttribute("list2", list2);
		req.setAttribute("paging", paging);
		req.setAttribute("categoryId", categoryId);
		req.getRequestDispatcher("/jsp/showList.jsp").forward(req, resp);
	}
}
