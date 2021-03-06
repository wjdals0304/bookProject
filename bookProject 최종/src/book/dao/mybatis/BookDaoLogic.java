package book.dao.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import book.dao.BookDao;
import book.dao.BookMybatisSessionFactoy;
import book.dao.mapper.BookMapper;
import book.domain.Book;
import book.domain.PurchasedInfo;

public class BookDaoLogic implements BookDao {

	@Override
	public List<Book> showNewBookList() {
		//
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();

		BookMapper mapper = session.getMapper(BookMapper.class);

		List<Book> newBookList = mapper.showNewBookList();

		session.close();

		return newBookList;

	}


	@Override
	public List<Book> showCustomedBookList(String categoryId) {
		//
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();

		BookMapper mapper = session.getMapper(BookMapper.class);

		List<Book> bookList = mapper.showCustomedBookList(categoryId);

		session.close();

		return bookList;

	}

	@Override
	public List<Book> searchBookByCategory(String keyword, String categoryId) {

		Map<String, Object> catemap = new HashMap<>();
		List<Book> bookList = new ArrayList<>();

		catemap.put("keyword", "%" + keyword + "%");
		catemap.put("categoryId", categoryId);

		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();

		BookMapper mapper = session.getMapper(BookMapper.class);
		bookList = mapper.searchBookByCategory(catemap);
		session.close();

		return bookList;
	}

	@Override
	public List<Book> searchBookByCategoryPaging(HashMap<String, Object> map) {
		//
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();

		BookMapper mapper = session.getMapper(BookMapper.class);

		List<Book> bookList = mapper.searchBookByCategoryPaging(map);

		session.close();

		return bookList;
	}

	@Override
	public List<Book> searchBookByKeyword(String keyword) {

		List<Book> list = new ArrayList<>();

		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();

		BookMapper mapper = session.getMapper(BookMapper.class);

		list = mapper.searchBookByKeyword("%" + keyword + "%");

		session.close();

		return list;
	}

	@Override
	public List<Book> searchBookByKeywordPaging(HashMap<String, Object> map) {
		//
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();

		BookMapper mapper = session.getMapper(BookMapper.class);

		List<Book> bookList = mapper.searchBookByKeywordPaging(map);

		session.close();

		return bookList;
	}

	@Override
	public List<Book> retrieveAllByCategoryId(String categoryId) {
		//
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();

		BookMapper mapper = session.getMapper(BookMapper.class);

		List<Book> bookList = mapper.retrieveAllByCategoryId(categoryId);

		session.close();

		return bookList;
	}

	@Override
	public List<Book> retrieveAllByCategoryIdPaging(HashMap<String, Object> map) {
		//
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();

		BookMapper mapper = session.getMapper(BookMapper.class);

		List<Book> bookList = mapper.retrieveAllByCategoryIdPaging(map);

		session.close();

		return bookList;
	}

	@Override
	public Book retrieveBook(String bookId) {
		//
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();

		BookMapper mapper = session.getMapper(BookMapper.class);

		Book book = mapper.retrieveBook(bookId);

		session.close();

		return book;

	}

	@Override
	public void updateGpa(Book book) {

		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();

		BookMapper mapper = session.getMapper(BookMapper.class);
		
		mapper.updateGpa(book);
		
		session.close();
	}

	@Override
	public Book retrieveByCategoryId(HashMap<String, String> map) {
		//
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();

		BookMapper mapper = session.getMapper(BookMapper.class);

		Book book = mapper.retrieveByCategoryId(map);

		session.close();

		return book;

	}

	@Override
	public void updateSalesVolume(Book changeBook) {

		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();

		BookMapper mapper = session.getMapper(BookMapper.class);

		mapper.updateSalesVolume(changeBook);

		session.close();
	}

}
