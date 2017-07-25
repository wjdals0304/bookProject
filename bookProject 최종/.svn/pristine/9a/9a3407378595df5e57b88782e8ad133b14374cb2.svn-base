package book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.UserService.UserService;
import book.UserService.UserServiceLogic;

@WebServlet("/member/loginIdCheck")
public class LoginIdCheckServlet extends HttpServlet {

	private static final long serialVersionUID = 2782450283692572642L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String registerId = req.getParameter("registerId");

	
		UserService userService = new UserServiceLogic();

		String loginId = userService.checkLoginId(registerId);

		if (loginId != null) {
			req.setAttribute("loginId", "");
			req.setAttribute("exsit", "t");
			req.getRequestDispatcher("/jsp/membershipTest.jsp").forward(req, resp);
			return;
		} else {
			req.setAttribute("exsit", "f");
			req.setAttribute("loginId", registerId);
			req.getRequestDispatcher("/jsp/membershipTest.jsp").forward(req, resp);
			return;
		}

	}
}
