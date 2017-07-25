package book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.cartService.CartService;
import book.cartService.CartServiceLogic;

@WebServlet("/basketItem/delete")
public class BasketDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 9164239245216987359L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String basketItemId = req.getParameter("basketItemId");
		
		CartService cartService = new CartServiceLogic();
		cartService.removeBasketItem(basketItemId);
		
		resp.sendRedirect("/bookMarket/basketItem/list");
	}
}
