package book.dao.mapper;

import java.util.HashMap;
import java.util.List;

import book.domain.Order;

public interface OrderMapper {

	public List<String> retrieveOrderByMonth();
	
	public List<String> retrieveOrderByBookId(String bookId);
	
	public List<String> retrieverOrderByMemberId(List<String> memberId);

	public void createOrder(Order order);

	public String retrieveMyOrderId(String memberId);

	public List<Order> retrieveAllByMemberId(String memberId);

	public List<Order> pagingOrderList(HashMap<String, String> pagingMap);

	public List<Order> retrieveAllByPeriod(HashMap<String, String> periodMap);

	public List<Order> pagingPeriodOrderList(HashMap<String, String> periodMap);
	
}
