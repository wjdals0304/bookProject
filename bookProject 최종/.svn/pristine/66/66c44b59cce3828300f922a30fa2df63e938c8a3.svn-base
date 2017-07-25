package book.dao;

import java.util.HashMap;
import java.util.List;

import book.domain.Order;

public interface OrderDao {

	public List<String> retrieveOrderByMonth();
	
	public List<String> retrieveOrderByBookId(String bookId);
	
	public List<String> retrieverOrderByMemberId(List<String> memberId);

	public void createOrder(Order order);

	public String retrieveMyOrderId(String memberId);

	// 멤버아이디로 주문목록 가져오기
	public List<Order> retrieveAllByMemberId(String memberId);
	
	public List<Order> pagingOrderList(HashMap<String,String> pagingMap);
	
	public List<Order> retrieveAllByPeriod(HashMap<String,String> periodMap);

	public List<Order> pagingPeriodOrderList(HashMap<String, String> periodMap);
	
}
