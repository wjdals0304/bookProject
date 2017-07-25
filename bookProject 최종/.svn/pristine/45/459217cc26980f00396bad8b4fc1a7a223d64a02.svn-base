package book.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import book.UserService.UserService;
import book.UserService.UserServiceLogic;
import book.cartService.CartService;
import book.cartService.CartServiceLogic;
import book.domain.Basket;
import book.domain.BasketItem;
import book.domain.Degree;
import book.domain.Member;

@WebServlet("/basketItem/list")
public class BasketListServlet extends HttpServlet {

	private static final long serialVersionUID = -5033132597865441919L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if (req.getSession().getAttribute("member") != null) {
			Member member = (Member) req.getSession().getAttribute("member");
			
			UserService userService = new UserServiceLogic();
			Degree degree = userService.findDegree(member.getDegreeId());
			
			CartService cartService = new CartServiceLogic();
			Basket basket = cartService.findBasket(member.getMemberId());
			List<BasketItem> basketItemList = basket.getBasketItemList();
			
			req.setAttribute("basketItemList", basketItemList);
			req.setAttribute("degree", degree);
		}
		
		
		req.getRequestDispatcher("/jsp/basket.jsp").forward(req, resp);
	}
}
