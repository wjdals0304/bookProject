package book.dao;

import java.util.HashMap;
import java.util.List;

import book.domain.Book;
import book.domain.PurchasedInfo;

public interface BookDao {
	
	public List<Book> showNewBookList();
	public List<Book> showCustomedBookList(String categoryId);
	//Add Method - 정수
	public List<Book> searchBookByCategory(String keyword, String categoryId);
	public List<Book> searchBookByCategoryPaging(HashMap<String, Object> map);
	public List<Book> searchBookByKeyword(String keyword);
	public List<Book> searchBookByKeywordPaging(HashMap<String, Object> map);
	public List<Book> retrieveAllByCategoryId(String categoryId);
	public List<Book> retrieveAllByCategoryIdPaging(HashMap<String, Object> map);
	
	public Book retrieveBook(String bookId);
	public void updateGpa(Book book);
	
	public Book retrieveByCategoryId(HashMap <String, String> map);
	public void updateSalesVolume(Book changeBook);

}
