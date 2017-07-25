package book.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.cartService.CartService;
import book.cartService.CartServiceLogic;
import book.domain.Basket;
import book.domain.BasketItem;
import book.domain.Book;
import book.domain.Member;

@WebServlet("/basketItem/create")
public class BasketItemCreateServlet extends HttpServlet {

	private static final long serialVersionUID = 6495651717532043462L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String bookId = req.getParameter("bookId");
		String count = req.getParameter("count");

		
		if (req.getSession().getAttribute("member") != null) {
						
			Book book = new Book();
			book.setBookId(bookId);
			
			Member member = (Member) req.getSession().getAttribute("member");
			
			CartService cartService = new CartServiceLogic();
			
			Basket basket = cartService.findBasket(member.getMemberId());

			BasketItem basketItem = new BasketItem();
			basketItem.setBasketId(basket.getBasketId());
			basketItem.setBook(book);
			basketItem.setCount(Integer.parseInt(count));
			
			cartService.registerBasketItem(basketItem);
		}
		
		resp.sendRedirect("/bookMarket/basketItem/list");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getSession().getAttribute("member") != null) {
			Member member = (Member) req.getSession().getAttribute("member");

			HashMap<String,String> map = new HashMap<>();
			
			String[] query = req.getParameterValues("check");

			for(int i=0;i<query.length;i++){
				String[] result = query[i].split(",");
				map.put(result[0], result[1]);
			}
			
			Iterator<String> iterator = map.keySet().iterator();
			
			while(iterator.hasNext()){
				
				String bookId = (String) iterator.next();
				int count = Integer.parseInt(map.get(bookId));
				
				Book book = new Book();
				book.setBookId(bookId);
				
				CartService cartService = new CartServiceLogic();
				Basket basket = cartService.findBasket(member.getMemberId());
				
				BasketItem basketItem = new BasketItem();
				basketItem.setBasketId(basket.getBasketId());
				basketItem.setBook(book);
				basketItem.setCount(count);
				
				cartService.registerBasketItem(basketItem);
			}
		}
		resp.sendRedirect("/bookMarket/basketItem/list");
	}
}
