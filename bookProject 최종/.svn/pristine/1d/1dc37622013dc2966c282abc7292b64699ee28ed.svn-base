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
import book.cartService.CartService;
import book.cartService.CartServiceLogic;
import book.domain.Basket;
import book.domain.Degree;
import book.domain.Member;

@WebServlet("/member/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -2137473602707934478L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String loginId = req.getParameter("inputEmail");
		String password = req.getParameter("inputPassword");

		HttpSession session = req.getSession();
		UserService userService = new UserServiceLogic();

		Member member = userService.loginCheck(loginId);
		
		if(member != null){
		Degree degree = userService.findDegree(member.getDegreeId());
		session.setAttribute("degree", degree);
		}
		
		if (member == null) {
			// 없는 아이디
			req.setAttribute("loginIdCheck", "idFalse");
			req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
			return;
		} else if (!member.getPassword().equals(password)) {
			// 패스워드 다름
			req.setAttribute("loginPwCheck", "pwFalse");
			req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
			return;
		} else {
			// 둘 다 맞음
			session.setAttribute("member", member);

			
			CartService cartService = new CartServiceLogic();
			Basket basket = cartService.findBasket(member.getMemberId());
			
			cartService.removeBasketItemWithLogin(basket.getBasketId());
			
			resp.sendRedirect("/bookMarket/book/main");
		}
	}
}
