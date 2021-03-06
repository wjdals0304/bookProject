package book.dao.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import book.domain.Book;

public interface BookMapper {
	
	public List<Book> showNewBookList();
	public List<Book> showCustomedBookList(String categoryId);
	//Add Mapper - 정수
	public List<Book> searchBookByCategory(Map<String, Object> map);
	public List<Book> searchBookByCategoryPaging(Map<String, Object> map);
	public List<Book> searchBookByKeyword(String keyword);
	public List<Book> searchBookByKeywordPaging(Map<String, Object> map);
	public List<Book> retrieveAllByCategoryId(String categoryId);
	public List<Book> retrieveAllByCategoryIdPaging(Map<String, Object> map);
	
	public Book retrieveBook(String bookId);
	public void updateGpa(Book book);
	
	public Book retrieveByCategoryId(HashMap <String, String> map);
	public void updateSalesVolume(Book changeBook);

}
