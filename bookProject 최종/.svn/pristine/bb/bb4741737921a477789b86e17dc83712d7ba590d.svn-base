package book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/logout")
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = -4664648479253678971L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 로그아웃은 세션을 만료시키는 기능입니다.
		HttpSession session = req.getSession();
		session.invalidate();

		resp.sendRedirect("/bookMarket/book/main");

	}
}
