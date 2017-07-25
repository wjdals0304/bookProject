package book.dao.mybatis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import book.bookService.BookService;
import book.bookService.BookServiceLogic;
import book.domain.Book;
import book.domain.Category;
import book.domain.CustomedInfo;
import book.domain.Member;
import book.domain.Order;
import book.domain.PurchasedInfo;

public class BookServiceLogicTest {
	
	private BookService service;
	
	@Before
	public void setUp() throws Exception {
		//
		service = new BookServiceLogic();
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	// 베스트 셀러 리스트 조회
	@Test
	public void testShowBestSellerList() {
		//
		List<Book> bookList = service.showBestSellerList();
		assertEquals(4, bookList.size());
	}
	
	// 신간 도서 리스트 조회
	@Test
	public void testShowNewBookList() {
		//
		List<Book> bookList = service.showNewBookList();
		assertEquals(3, bookList.size());
		
	}
	
	// 추천 도서 리스트 조회
	@Test
	public void testShowRecommendedBookList() {
		//
		List<Book> bookList = service.showRecommendedBookList("35");
		assertNotNull(bookList);
	}

	// 맞춤도서를 위한 멤버 정보 저장
	@Test
	public void testCreateCustomedInfo() {
		CustomedInfo customedInfo = new CustomedInfo();
		Book book = new Book();
		customedInfo.setMemberId("101");
		book.setBookId("37");
		customedInfo.setBook(book);
		
		service.createCustomedInfo(customedInfo);
		
		assertTrue(true);
	}

	// 맞춤도서 정보가 테이블에 있는지 조회
	@Test
	public void testRetrieveByMemberId() {
		//
		CustomedInfo costomedInfo = service.retrieveByMemberId("1");
		assertNotNull(costomedInfo);
	}
	// 맞춤도서 리스트 조회
	@Test
	public void testShowCustomedBookList() {
		//
		List<Book> bookList = service.showCustomedBookList("101");
		assertEquals(5, bookList.size());
	}

	// 검색(카테고리 + 키워드)
	@Test
	public void testSearchBookByCategory() {
		//
		List<Book> bookList = service.searchBookByCategory("구르미", "2");
		assertNotNull(bookList);
	}

	// 검색(키워드)
	@Test
	public void testSearchBookByKeyword() {
		//
		List<Book> bookList = service.searchBookByKeyword("구르미");
		assertNotNull(bookList);
	}

	// 카테고리 목록 조회
	@Test
	public void testRetrieveAllBookByCategory() {
		//
		List<Book> bookList = service.retrieveAllBookByCategory("2");
		assertNotNull(bookList);
		
	}
	// 북아이디로 북 정보 조회
	@Test
	public void testFindBook() {
		//
		Book book = service.findBook("35");
		assertNotNull(book);		
	}

	// 카테고리 리스트 조회(메인, 메뉴 리스트 조회시)
	@Test
	public void testRetrieveAll() {
		//
		List<Category> categoryList = service.retrieveAll();
		assertEquals(12, categoryList.size());
	}

	//memberId로 order리스트 조회
	@Test
	public void testRetrieveAllByMemberId() {
		//
		List<Order> orderList = service.retrieveAllByMemberId("61");
		assertNotNull(orderList);	
	}

	//특정 기간에 해당하는 전체 리스트 가져오기
	@Test
	public void testRetrieveAllByPeriod() {
		//
		HashMap<String, String> periodMap = new HashMap<>();
		periodMap.put("startDate", "2016-11-01");
		periodMap.put("endDate", "2016-11-10");
		periodMap.put("memberId","70");
		List<Order> orderList = service.retrieveAllByPeriod(periodMap);
		assertNotNull(orderList);	
	}

	@Test
	public void testCreateOrder() {
		Order order = new Order();
		order.setMemberId("70");
		order.setTotalPrice(55000);
		service.createOrder(order);
	}

	@Test
	public void testRetrieveMyOrderId() {
		
		String orderId = service.retrieveMyOrderId("78");
	}

	@Test
	public void testCreatePurchasedInfo() {
		List<PurchasedInfo> purchasedInfoList = new ArrayList<>();
		PurchasedInfo purchasedInfo = new PurchasedInfo(); 
		 purchasedInfo.setOrderId("152");
		 Book book = new Book();
		 
		 Member member = new Member();
		 member.setMemberId("70");
		 book.setBookId("8");
		 purchasedInfo.setBook(book);
		 purchasedInfo.setOrderId("167");
		 purchasedInfo.setCount(4);
		 purchasedInfoList.add(purchasedInfo);
		 
		 service.createPurchasedInfo(purchasedInfoList, member);
		
	}

	@Test
	public void testCheckPurchasedInfoIdByOrderIdMemberId() {
		//
		HashMap<String, String> map = new HashMap<>();
		map.put("orderId", "108");
		map.put("bookId", "23");
		
		String check = service.checkPurchasedInfoIdByOrderIdMemberId(map);
		
		assertNotNull(check);	
		
	}

}
