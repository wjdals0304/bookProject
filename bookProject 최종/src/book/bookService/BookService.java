package book.bookService;

import java.util.HashMap;
import java.util.List;

import book.domain.Book;
import book.domain.Category;
import book.domain.CustomedInfo;
import book.domain.Member;
import book.domain.Order;
import book.domain.PurchasedInfo;

public interface BookService {

	public List<Book> showBestSellerList();
	public List<Book> showNewBookList();
	public List<Book> showRecommendedBookList(String bookId);
	public List<Book> showCustomedBookList(String memberId);
	public CustomedInfo retrieveByMemberId(String memberId);
	public void createCustomedInfo(CustomedInfo customedInfo);
	//Add Method - 정수 
	public List<Book> searchBookByCategory(String keyword, String categoryId);
	public List<Book> searchBookByCategoryPaging(HashMap<String, Object> map);
	public List<Book> searchBookByKeyword(String keyword);
	public List<Book> searchBookByKeywordPaging(HashMap<String, Object> map);
	public List<Book> retrieveAllBookByCategory(String categoryId);
	public List<Book> retrieveAllBookByCategoryPaging(HashMap<String, Object> map);
	
	public Book findBook(String bookId);
	
	public List<Order> retrieveAllByMemberId(String memberId);
	
	public List<Category> retrieveAll();
	
	
	public List<Order> pagingOrderList(HashMap<String,String> pagingMap);
	public List<Order> retrieveAllByPeriod(HashMap<String,String> periodMap); 
	public List<Order> pagingPeriodOrderList(HashMap<String,String> periodMap);

	
	public void createOrder(Order order);
	public String retrieveMyOrderId(String memberId);
	public void createPurchasedInfo(List<PurchasedInfo> purchasedInfoList, Member member);
	
	
	public String checkPurchasedInfoIdByOrderIdMemberId(HashMap<String, String> map);
}
