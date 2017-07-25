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

import book.bookService.BookService;
import book.bookService.BookServiceLogic;
import book.domain.Book;
import book.domain.PurchasedInfo;

@WebServlet("/purchasedInfo/order")
public class OrderServlet extends HttpServlet {

   private static final long serialVersionUID = 8234628972121566468L;

   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

      BookService bookService = new BookServiceLogic();
      
      HashMap<String,String> map = new HashMap<>();
      
      String[] query = req.getParameterValues("check");
      
      List<String> basketItemIdList = new ArrayList<>();
      
      for(int i=0;i<query.length;i++){
          String[] result = query[i].split(",");
          if ( result.length == 2 ) {
         	 map.put(result[0], result[1]);
          }
          else if ( result.length == 3 ){
         	 map.put(result[0], result[1]);
         	 basketItemIdList.add(result[2]);
          }
      }
      
      List<PurchasedInfo> purchasedInfoList = new  ArrayList<>();
      
      Iterator<String> iterator = map.keySet().iterator();
      
      while(iterator.hasNext()){
         
         String key =(String) iterator.next();
         
         int count = Integer.parseInt(map.get(key));
         Book book = new Book();
         book.setBookId(key);
         
         book =  bookService.findBook(book.getBookId());
         
         PurchasedInfo purchasedInfo = new PurchasedInfo();
         
         purchasedInfo.setBook(book);

         purchasedInfo.setCount(count);
         
         purchasedInfoList.add(purchasedInfo);
      
      }
      
      req.setAttribute("basketItemIdList", basketItemIdList);
      req.setAttribute("purchasedInfoList", purchasedInfoList);
      
      req.getRequestDispatcher("/jsp/order.jsp").forward(req, resp);
   }
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      BookService bookService = new BookServiceLogic();
      String bookId= req.getParameter("bookId");
      String count = req.getParameter("count"); 
      
      List<PurchasedInfo> purchasedInfoList = new  ArrayList<>();
      
      int countInt = Integer.parseInt(count); 
      
      Book book = bookService.findBook(bookId);
      
      PurchasedInfo purchasedInfo = new PurchasedInfo(); 
      
      purchasedInfo.setBook(book);
      purchasedInfo.setCount(countInt);
      
      purchasedInfoList.add(purchasedInfo); 
      
      req.setAttribute("purchasedInfoList", purchasedInfoList);
      
      req.getRequestDispatcher("/jsp/order.jsp").forward(req, resp);
   }
}