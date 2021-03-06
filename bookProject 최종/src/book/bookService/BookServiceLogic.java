package book.bookService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import book.dao.BookDao;
import book.dao.CategoryDao;
import book.dao.CustomedInfoDao;
import book.dao.DegreeDao;
import book.dao.MemberDao;
import book.dao.OrderDao;
import book.dao.PurchasedInfoDao;
import book.dao.mybatis.BookDaoLogic;
import book.dao.mybatis.CategoryDaoLogic;
import book.dao.mybatis.CustomedInfoDaoLogic;
import book.dao.mybatis.DegreeDaoLogic;
import book.dao.mybatis.MemberDaoLogic;
import book.dao.mybatis.OrderDaoLogic;
import book.dao.mybatis.PurchasedInfoDaoLogic;
import book.domain.Book;
import book.domain.Category;
import book.domain.CustomedInfo;
import book.domain.Degree;
import book.domain.Member;
import book.domain.Order;
import book.domain.PurchasedInfo;

public class BookServiceLogic implements BookService {

	private BookDao bookDao;
	private CategoryDao categoryDao;
	private OrderDao orderDao;
	private PurchasedInfoDao purchasedInfoDao;
	private CustomedInfoDao customedInfoDao;
	private DegreeDao degreeDao;
	private MemberDao memberDao;
	
	
	public BookServiceLogic() {
		this.bookDao = new BookDaoLogic();
		this.categoryDao = new CategoryDaoLogic();
		this.orderDao = new OrderDaoLogic();
		this.purchasedInfoDao = new PurchasedInfoDaoLogic();
		this.customedInfoDao = new CustomedInfoDaoLogic();
		this.degreeDao = new DegreeDaoLogic();
		this.memberDao = new MemberDaoLogic();
	}

	// 베스트 셀러 리스트 조회 - 명선
	 @Override
	   public List<Book> showBestSellerList() {
	      
	      if(orderDao.retrieveOrderByMonth().size() == 0){
	         return null;
	      }
	      else{
	         
	         List<String> orderIdList = orderDao.retrieveOrderByMonth();
	         
	         List<PurchasedInfo> purchasedInfoList = purchasedInfoDao.retrievePurchasedCountByMonth(orderIdList);
	         
	         List<Book> bestSellerList = new ArrayList<>();
	         for (PurchasedInfo purchasedInfo : purchasedInfoList) {
	            Book book = bookDao.retrieveBook(purchasedInfo.getBook().getBookId());
	            Category category = categoryDao.retrieveByCategoryId(book.getCategory().getCategoryId());
	            book.setCategory(category);
	            
	            bestSellerList.add(book);
	         }
	      return bestSellerList;
	      }
	   }
	// 신간 도서 리스트 조회 - 명선
	@Override
	public List<Book> showNewBookList() {

		List<Book> bookList = bookDao.showNewBookList();
		List<Book> bookList2 = new ArrayList<>();

		for (Book book : bookList) {
			Category category = categoryDao.retrieveByCategoryId(book.getCategory().getCategoryId());
			book.setCategory(category);
			bookList2.add(book);
		}
		return bookList2;
	}

	// 추천 도서 리스트 조회 - 명선
	@Override
	public List<Book> showRecommendedBookList(String bookId) {
		List<String> memberIdList = orderDao.retrieveOrderByBookId(bookId);
		List<Book> bookIdListF = new ArrayList<>();
		
		if (memberIdList.size() == 0) {
			return null;
		}

		List<String> bookIdList = orderDao.retrieverOrderByMemberId(memberIdList);

		List<Book> bookList = new ArrayList<>();
		Book book = bookDao.retrieveBook(bookId);

		String categoryId = book.getCategory().getCategoryId();
		
		for (String bookIdF : bookIdList) {
			
			HashMap<String, String> map = new HashMap<>();
			map.put("categoryId", categoryId);
			map.put("bookId", bookIdF);

			Book bookF = bookDao.retrieveByCategoryId(map);
			
			if (bookF != null) {
				bookList.add(bookF);
			}
		}
		if(bookList.size()>5){
			for (int i = 0; i < 5; i++) {
				bookIdListF.add(bookList.get(i));
			}
			
		}else{
			for(int j=0; j<bookList.size(); j++){
				bookIdListF.add(bookList.get(j));
			}
		}
		
		return bookIdListF;
	}

	// 맞춤도서를 위한 멤버 정보 저장 - 명선
	@Override
	public void createCustomedInfo(CustomedInfo customedInfo) {
		//
		// login후 접속했는지 비교 로직
		if (customedInfo.getMemberId() != null) {
			CustomedInfo customedInfoBook = customedInfoDao.retrieveByMemberId(customedInfo.getMemberId());
			if (customedInfoBook == null) {
				customedInfoDao.create(customedInfo);
			} else {
				customedInfoDao.update(customedInfo);
			}
		}

	}

	@Override
	public CustomedInfo retrieveByMemberId(String memberId) {
		//
		CustomedInfo customedInfo = customedInfoDao.retrieveByMemberId(memberId);

		return customedInfo;

	}

	// 맞춤도서 리스트 조회 - 명선
	@Override
	public List<Book> showCustomedBookList(String memberId) {
		//
		CustomedInfo customedInfoBook = customedInfoDao.retrieveByMemberId(memberId);
		Book book = bookDao.retrieveBook(customedInfoBook.getBook().getBookId());

		List<Book> customedBook = bookDao.showCustomedBookList(book.getCategory().getCategoryId());
		List<Book> customedBookList = new ArrayList<>();

		for (Book customed : customedBook) {
			Category category = categoryDao.retrieveByCategoryId(customed.getCategory().getCategoryId());
			customed.setCategory(category);
			customedBookList.add(customed);
		}
		return customedBookList;

	}

	// search(keyword / categoryId) & paging method - 정수
	@Override
	public List<Book> searchBookByCategory(String keyword, String categoryId) {
		return bookDao.searchBookByCategory(keyword, categoryId);
	}

	@Override
	public List<Book> searchBookByCategoryPaging(HashMap<String, Object> map) {
		//
		String index = (String) map.get("index");
		int indexInt = Integer.parseInt(index);
		int a = 1;
		int b = -5;
		for (int i = 0; i < indexInt; i++) {
			int j = a + ((int) map.get("pageSize"));
			a = j;
			int k = b + ((int) map.get("pageSize"));
			b = k;
		}
		map.put("startNum", b);
		map.put("endNum", a);

		return bookDao.searchBookByCategoryPaging(map);
	}

	@Override
	public List<Book> searchBookByKeyword(String keyword) {
		return bookDao.searchBookByKeyword(keyword);
	}

	@Override
	public List<Book> searchBookByKeywordPaging(HashMap<String, Object> map) {
		//
		String index = (String) map.get("index");
		int indexInt = Integer.parseInt(index);
		int a = 1;
		int b = -5;
		for (int i = 0; i < indexInt; i++) {
			int j = a + ((int) map.get("pageSize"));
			a = j;
			int k = b + ((int) map.get("pageSize"));
			b = k;
		}
		map.put("startNum", b);
		map.put("endNum", a);

		return bookDao.searchBookByKeywordPaging(map);
	}

	@Override
	public List<Book> retrieveAllBookByCategory(String categoryId) {
		//
		return bookDao.retrieveAllByCategoryId(categoryId);
	}

	@Override
	public List<Book> retrieveAllBookByCategoryPaging(HashMap<String, Object> map) {
		//
		String index = (String) map.get("index");
		int indexInt = Integer.parseInt(index);
		int a = 1;
		int b = -5;
		for (int i = 0; i < indexInt; i++) {
			int j = a + ((int) map.get("pageSize"));
			a = j;
			int k = b + ((int) map.get("pageSize"));
			b = k;
		}

		map.put("startNum", b);
		map.put("endNum", a);

		return bookDao.retrieveAllByCategoryIdPaging(map);
	}

	// 북아이디로 북 정보 조회 - 명선
	@Override
	public Book findBook(String bookId) {
		//
		Book book = bookDao.retrieveBook(bookId);
		Category category = categoryDao.retrieveByCategoryId(book.getCategory().getCategoryId());
		book.setCategory(category);
		
		return book;
		
	}

	// 카테고리 리스트 조회(메인, 메뉴 리스트 조회시) - 명선
	@Override
	public List<Category> retrieveAll() {
		return categoryDao.retrieveAll();
	}
	
	// memberId로 order리스트 조회 -정민
		public List<Order> retrieveAllByMemberId(String memberId) {
			List<Order> orderList = orderDao.retrieveAllByMemberId(memberId);
	
			for (Order order : orderList) {

				List<PurchasedInfo> purchasedInfoList = purchasedInfoDao.retrieveAllByOrderId(order.getOrderId());

				for (PurchasedInfo purchasedInfo : purchasedInfoList) {
					Book book = bookDao.retrieveBook(purchasedInfo.getBook().getBookId());

					PurchasedInfo purchasedInfoCount = new PurchasedInfo();
					purchasedInfoCount.setOrderId(order.getOrderId());
					purchasedInfoCount.setPurchasedInfoId(purchasedInfo.getPurchasedInfoId());
					purchasedInfoCount.setBook(book);
				
					purchasedInfo.setBook(book);
				}
			
				order.setPurchasedInfoList(purchasedInfoList);
			}

			return orderList;
		}

		// 3개월 만 조회 -- 정민
		public List<Order> pagingOrderList(HashMap<String, String> pagingMap) {

			String end = null;
			String start = null;

			int indexInt = Integer.parseInt(pagingMap.get("index"));
			int pageSize = Integer.parseInt(pagingMap.get("pageSize"));
			end = "1";
			start = "-5";
			for (int i = 0; i < indexInt; i++) {
				int j = Integer.parseInt(end) + pageSize;
				end = String.format("%d", j);
				int k = Integer.parseInt(start) + pageSize;
				start = String.format("%d", k);
			}
			pagingMap.put("end", end);
			pagingMap.put("start", start);

			List<Order> orderList = orderDao.pagingOrderList(pagingMap);
		
			for (Order order : orderList) {

				List<PurchasedInfo> purchasedInfoList = purchasedInfoDao.retrieveAllByOrderId(order.getOrderId());

				for (PurchasedInfo purchasedInfo : purchasedInfoList) {
					Book book = bookDao.retrieveBook(purchasedInfo.getBook().getBookId());

					PurchasedInfo purchasedInfoCount = new PurchasedInfo();
					purchasedInfoCount.setOrderId(order.getOrderId());
					purchasedInfoCount.setPurchasedInfoId(purchasedInfo.getPurchasedInfoId());
					purchasedInfoCount.setBook(book);
					purchasedInfo.setBook(book);
				}
				order.setPurchasedInfoList(purchasedInfoList);
			}
			return orderList;
		}

		//특정 기간에 해당하는 전체 리스트 가져오기  -정민 
		@Override
		public List<Order> retrieveAllByPeriod(HashMap<String, String> periodMap) {
			List<Order> orderList = orderDao.retrieveAllByPeriod(periodMap);

			for (Order order : orderList) {

				List<PurchasedInfo> purchasedInfoList = purchasedInfoDao.retrieveAllByOrderId(order.getOrderId());

				for (PurchasedInfo purchasedInfo : purchasedInfoList) {
					Book book = bookDao.retrieveBook(purchasedInfo.getBook().getBookId());

					PurchasedInfo purchasedInfoCount = new PurchasedInfo();
					purchasedInfoCount.setOrderId(order.getOrderId());
					purchasedInfoCount.setPurchasedInfoId(purchasedInfo.getPurchasedInfoId());
					purchasedInfoCount.setBook(book);
					purchasedInfo.setBook(book);
				}
				order.setPurchasedInfoList(purchasedInfoList);
				
			}
			return orderList;
		}

		//특정기간에 pageSize 개수만 가져오기 --정민 
		@Override
		public List<Order> pagingPeriodOrderList(HashMap<String, String> periodMap) {
			String end = null;
			String start = null;

			int indexInt = Integer.parseInt(periodMap.get("index"));
			int pageSize = Integer.parseInt(periodMap.get("pageSize"));
			end = "1";
			start = "-5";
			for (int i = 0; i < indexInt; i++) {
				int j = Integer.parseInt(end) + pageSize;
				end = String.format("%d", j);
				int k = Integer.parseInt(start) + pageSize;
				start = String.format("%d", k);
			}
			periodMap.put("end", end);
			periodMap.put("start", start);
			List<Order> orderList = orderDao.pagingPeriodOrderList(periodMap);

			for (Order order : orderList) {
				List<PurchasedInfo> purchasedInfoList = purchasedInfoDao.retrieveAllByOrderId(order.getOrderId());

				for (PurchasedInfo purchasedInfo : purchasedInfoList) {
					Book book = bookDao.retrieveBook(purchasedInfo.getBook().getBookId());
					PurchasedInfo purchasedInfoCount = new PurchasedInfo();
					purchasedInfoCount.setOrderId(order.getOrderId());
					purchasedInfoCount.setPurchasedInfoId(purchasedInfo.getPurchasedInfoId());
					purchasedInfoCount.setBook(book);
					purchasedInfo.setBook(book);
				}
				order.setPurchasedInfoList(purchasedInfoList);
			}
			return orderList;
		}

		
		// order create -정민 
		@Override
		public void createOrder(Order order) {
			orderDao.createOrder(order);
		}

		// 내가 주문한 orderId 가져오기 --정민 
		@Override
		public String retrieveMyOrderId(String memberId) {
			return orderDao.retrieveMyOrderId(memberId);
		}

		// 구매리스트 등록하기 -정민 
		@Override
		public void createPurchasedInfo(List<PurchasedInfo> purchasedInfoList,Member member) {
			for (PurchasedInfo purchasedInfo : purchasedInfoList) {
				Book changeBook = bookDao.retrieveBook(purchasedInfo.getBook().getBookId());
			
				int plus = changeBook.getSalesVolume();
				int result = purchasedInfo.getCount() + plus;

				changeBook.setSalesVolume(result);
				bookDao.updateSalesVolume(changeBook);
			}

			purchasedInfoDao.createPurchasedInfo(purchasedInfoList);

			List<Order> orderList = orderDao.retrieveAllByMemberId(member.getMemberId());
			int sum = 0;
			for (Order order : orderList) {
				int count = purchasedInfoDao.retrievePurchasedCount(order.getOrderId());
				sum = sum + count;
			}

			List<Degree> degreeList = degreeDao.retrieveAllDegreeList();
			 
			for (Degree degree : degreeList) {
				   if( sum >=  degree.getTargetCount() ) {
					   member.setDegreeId(degree.getDegreeId());
					   break;
				   }
			}
		
			memberDao.update(member);
			
		}

	@Override
	public String checkPurchasedInfoIdByOrderIdMemberId(HashMap<String, String> map) {
		
		String result = purchasedInfoDao.checkPurchasedInfoIdByOrderIdMemberId(map);

		if ( result == null ) {
			return "F";
		}
		else {
			return "T";
		}
	}
}
