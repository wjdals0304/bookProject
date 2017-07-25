package book.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import book.UserService.UserService;
import book.UserService.UserServiceLogic;
import book.bookService.BookService;
import book.bookService.BookServiceLogic;
import book.cartService.CartService;
import book.cartService.CartServiceLogic;
import book.domain.Book;
import book.domain.Degree;
import book.domain.Member;
import book.domain.Order;
import book.domain.PurchasedInfo;

@WebServlet("/purchasedInfo/create")
public class PurchasedInfoCreateServlet extends HttpServlet {

   private static final long serialVersionUID = -2636596036546477440L;

   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      // TODO Auto-generated method stub
      BookService bookService = new BookServiceLogic();
      UserService userService = new UserServiceLogic();

      HttpSession session = req.getSession();

      if (req.getSession().getAttribute("member") != null) {
         Member member = (Member) session.getAttribute("member");

         String[] query = req.getParameterValues("check");
         String[] basketItemIdList = req.getParameterValues("basketItemId");
      
         String totalPrice = req.getParameter("totalPrice");
         int total = (int) (Float.parseFloat(totalPrice));

         HashMap<String, String> map = new HashMap<>();

         for (int i = 0; i < query.length; i++) {
            String[] result = query[i].split(",");
            map.put(result[0], result[1]);
         }
         
         List<PurchasedInfo> purchasedInfoList = new ArrayList<>();

         Iterator<String> iterator = map.keySet().iterator();
         Order order = new Order();
         order.setMemberId(member.getMemberId());
         order.setTotalPrice(total);

         bookService.createOrder(order);

         while (iterator.hasNext()) {
            String key = (String) iterator.next();

            int count = Integer.parseInt(map.get(key));
            Book book = new Book();
            book.setBookId(key);

            String orderId = bookService.retrieveMyOrderId(order.getMemberId());

            PurchasedInfo purchasedInfo = new PurchasedInfo();

            purchasedInfo.setOrderId(orderId);

            purchasedInfo.setBook(book);

            purchasedInfo.setCount(count);

            purchasedInfoList.add(purchasedInfo);
         }

         bookService.createPurchasedInfo(purchasedInfoList, member);

         CartService cartService = new CartServiceLogic();
         
         if(basketItemIdList  != null ){
	         for ( int i = 0; i < basketItemIdList.length; i++ ) {
	        	 cartService.removeBasketItem(basketItemIdList[i]);
	         }
         }
         
         Degree degree = userService.findDegree(member.getDegreeId());
         session.setAttribute("degree", degree);

         resp.sendRedirect("/bookMarket/book/main");
      }
   }
}