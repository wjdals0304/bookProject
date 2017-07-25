package book.dao.mybatis;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import book.domain.Book;

public class BookDaoLogicTest {


	@Test
	public void testShowNewBookList() throws IOException{
		
		BookDaoLogic dao = new BookDaoLogic();
		
		List<Book> bookList = dao.showNewBookList();
		
		for(Book book : bookList){
			System.out.println(book);
		}
		
	}
	@Test
	public void testRetrieveBook() throws IOException{
		
		BookDaoLogic dao = new BookDaoLogic();
		
		Book book = dao.retrieveBook("4");
		
		System.out.println(book);
	}
	@Test
	public void testRetrieveByCategoryId() throws IOException{
		
		BookDaoLogic dao = new BookDaoLogic();
		
		HashMap<String, String> map = new HashMap<>();
		map.put("bookId", "8");
		map.put("categoryId", "1");
		
		Book book = dao.retrieveByCategoryId(map);
		System.out.println(book);
		
	}
	
}
