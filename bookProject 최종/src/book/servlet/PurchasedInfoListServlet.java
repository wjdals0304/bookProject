package book.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import book.bookService.BookService;
import book.bookService.BookServiceLogic;
import book.domain.BookListPaging;
import book.domain.Member;
import book.domain.Order;

@WebServlet("/purchasedInfo/list")
public class PurchasedInfoListServlet extends HttpServlet {

	private static final long serialVersionUID = 7356484920651864893L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doProcess(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		String startDate = req.getParameter("datepicker1");
		String endDate = req.getParameter("datepicker2");

		String index = req.getParameter("index");
		if (null == index) {
			index = "1";
		}
		req.setAttribute("index", index);

		HttpSession session = req.getSession();
		if (req.getSession().getAttribute("member") != null) {

			Member member = (Member) session.getAttribute("member");

			BookService bookService = new BookServiceLogic();

			if (startDate == null) {
				List<Order> orderList = bookService.retrieveAllByMemberId(member.getMemberId());

				int num = Integer.parseInt(index);
				BookListPaging paging = new BookListPaging();
				paging.setPageNo(num);
				paging.setPageSize(5);
				paging.setTotalCount(orderList.size());

				String pageSize = Integer.toString(paging.getPageSize());

				HashMap<String, String> pagingMap = new HashMap<String, String>();

				pagingMap.put("memberId", member.getMemberId());
				pagingMap.put("index", index);
				pagingMap.put("pageSize", pageSize);

				List<Order> pagingOrderList = bookService.pagingOrderList(pagingMap);
				req.setAttribute("paging", paging);
				req.setAttribute("orderList", orderList);
				req.setAttribute("pagingOrderList", pagingOrderList);
				req.getRequestDispatcher("/jsp/purchasedInfo.jsp").forward(req, resp);
				return;
			}

			HashMap<String, String> periodMap = new HashMap<>();
			periodMap.put("startDate", startDate);
			periodMap.put("endDate", endDate);
			periodMap.put("memberId", member.getMemberId());

			List<Order> orderList = bookService.retrieveAllByPeriod(periodMap);

			int num = Integer.parseInt(index);
			BookListPaging paging = new BookListPaging();
			paging.setPageNo(num);
			paging.setPageSize(5);
			paging.setTotalCount(orderList.size());
			String pageSize = Integer.toString(paging.getPageSize());

			periodMap.put("memberId", member.getMemberId());
			periodMap.put("index", index);
			periodMap.put("pageSize", pageSize);

			List<Order> pagingOrderList = bookService.pagingPeriodOrderList(periodMap);

			req.setAttribute("startDate", startDate);
			req.setAttribute("endDate", endDate);
			req.setAttribute("paging", paging);
			req.setAttribute("pagingOrderList", pagingOrderList);
			req.setAttribute("orderList", orderList);
			req.getRequestDispatcher("/jsp/purchasedInfo.jsp").forward(req, resp);
		}
	}

}
