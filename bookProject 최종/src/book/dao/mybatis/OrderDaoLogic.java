package book.dao.mybatis;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import book.dao.BookMybatisSessionFactoy;
import book.dao.OrderDao;
import book.dao.mapper.OrderMapper;
import book.dao.mapper.PurchasedInfoMapper;
import book.domain.Order;

public class OrderDaoLogic implements OrderDao {

	@Override
	public List<String> retrieveOrderByMonth() {
		//
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();

		OrderMapper mapper = session.getMapper(OrderMapper.class);

		List<String> orderIdList = mapper.retrieveOrderByMonth();

		session.close();

		return orderIdList;
	}

	@Override
	public List<String> retrieveOrderByBookId(String bookId) {
		//
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();

		OrderMapper mapper = session.getMapper(OrderMapper.class);

		List<String> memberIdList = mapper.retrieveOrderByBookId(bookId);

		session.close();

		return memberIdList;

	}

	@Override
	public List<String> retrieverOrderByMemberId(List<String> memberId) {
		//
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();

		OrderMapper mapper = session.getMapper(OrderMapper.class);

		List<String> bookIdList = mapper.retrieverOrderByMemberId(memberId);

		session.close();

		return bookIdList;

	}

	@Override
	public void createOrder(Order order) {
		// TODO Auto-generated method stub
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		OrderMapper mapper = session.getMapper(OrderMapper.class);
		mapper.createOrder(order);
		session.close();

	}

	@Override
	public String retrieveMyOrderId(String memberId) {
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		OrderMapper mapper = session.getMapper(OrderMapper.class);
		String orderId = mapper.retrieveMyOrderId(memberId);
		session.close();
		return orderId;
	}

	@Override
	public List<Order> retrieveAllByMemberId(String memberId) {
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		OrderMapper mapper = session.getMapper(OrderMapper.class);

		List<Order> orderList = mapper.retrieveAllByMemberId(memberId);
		session.close();
		return orderList;
	}

	@Override
	public List<Order> pagingOrderList(HashMap<String, String> pagingMap) {
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		OrderMapper mapper = session.getMapper(OrderMapper.class);

		List<Order> orderList = mapper.pagingOrderList(pagingMap);

		session.close();
		return orderList;
	}

	@Override
	public List<Order> retrieveAllByPeriod(HashMap<String, String> periodMap) {
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		OrderMapper mapper = session.getMapper(OrderMapper.class);

		List<Order> orderList = mapper.retrieveAllByPeriod(periodMap);
		session.close();
		return orderList;
	}

	@Override
	public List<Order> pagingPeriodOrderList(HashMap<String, String> periodMap) {
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		OrderMapper mapper = session.getMapper(OrderMapper.class);
		
		List<Order> orderList = mapper.pagingPeriodOrderList(periodMap);

		session.close();
		return orderList;
	}

}
