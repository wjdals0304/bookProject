package book.dao.mybatis;

import org.junit.Before;
import org.junit.Test;

import book.dao.CustomedInfoDao;
import book.dao.DegreeDao;
import book.dao.OrderDao;
import book.dao.PurchasedInfoDao;
import book.domain.Book;
import book.domain.CustomedInfo;

public class CustomedInfoDaoLogicTest {

	OrderDao orderDao;
	DegreeDao degreeDao;
	PurchasedInfoDao purchasedInfoDao;
	CustomedInfoDao customedInfoDao;
	@Before
	public void init(){
		//
		System.out.println("init");
		orderDao = new OrderDaoLogic();
		degreeDao = new DegreeDaoLogic();
		purchasedInfoDao = new PurchasedInfoDaoLogic();
		customedInfoDao = new CustomedInfoDaoLogic();
	}

	@Test
	public void testCreate() {	
		CustomedInfoDao dao = new CustomedInfoDaoLogic();
		Book book = new Book();
		book.setBookId("5");

		CustomedInfo customedInfo = new CustomedInfo();
		customedInfo.setMemberId("5");
		
		customedInfo.setBook(book);
		
		dao.create(customedInfo);
	}
	
	@Test
	public void testUpdate() {
		//
		CustomedInfoDao dao = new CustomedInfoDaoLogic();
		
		CustomedInfo customedInfo = new CustomedInfo();
		Book book = new Book();
		book.setBookId("1");
		customedInfo.setMemberId("1");
		customedInfo.setBook(book);
		
		dao.update(customedInfo);
	}

	@Test
	public void testRetrieveByMemberId() {
		
		CustomedInfoDao dao = new CustomedInfoDaoLogic();
		
		CustomedInfo customedInfo = dao.retrieveByMemberId("7");
		
		System.out.println(customedInfo);
	}

}
