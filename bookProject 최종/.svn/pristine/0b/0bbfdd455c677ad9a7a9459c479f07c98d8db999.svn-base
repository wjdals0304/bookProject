package book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.cartService.CartService;
import book.cartService.CartServiceLogic;
import book.domain.BasketItem;

@WebServlet("/basketItem/update")
public class BasketUpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 6261739982369349273L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String basketItemId = req.getParameter("basketItemId");
		String count = req.getParameter("count");
		int count2 = Integer.parseInt(count);
		
		BasketItem basketItem = new BasketItem();
		basketItem.setBasketItemId(basketItemId);
		basketItem.setCount(count2);

		CartService cartService = new CartServiceLogic();
		cartService.modifyBasketItem(basketItem);
		
		resp.sendRedirect("/bookMarket/basketItem/list");
	}
}
