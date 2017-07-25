package book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.UserService.UserService;
import book.UserService.UserServiceLogic;
import book.cartService.CartService;
import book.cartService.CartServiceLogic;
import book.domain.Member;

@WebServlet("/member/create")
public class MemberCreateServlet extends HttpServlet {

	private static final long serialVersionUID = -7611854834787485155L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String loginId = req.getParameter("inputEmail");
		String password = req.getParameter("inputPassword");
		String userName = req.getParameter("inputName");
		
		Member member = new Member();
		member.setLoginId(loginId);
		member.setPassword(password);
		member.setUserName(userName);
		
		UserService userService = new UserServiceLogic();
		userService.registerMember(member);
		
		Member member2 = userService.loginCheck(loginId);
		
		CartService cartService = new CartServiceLogic();
		cartService.createBasket(member2.getMemberId());
		
		resp.sendRedirect("/bookMarket/jsp/login.jsp");
	}
}
