package book.dao.mybatis;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import book.dao.BookMybatisSessionFactoy;
import book.dao.PurchasedInfoDao;
import book.dao.mapper.PurchasedInfoMapper;
import book.domain.Order;
import book.domain.PurchasedInfo;

public class PurchasedInfoDaoLogic implements PurchasedInfoDao {


	@Override
	public Integer retrievePurchasedCount(String orderId) {
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		PurchasedInfoMapper mapper = session.getMapper(PurchasedInfoMapper.class);
		Integer count = mapper.retrievePurchasedCount(orderId);
		session.close();
		return count;
	}

	@Override
	public List<PurchasedInfo> retrievePurchasedCountByMonth(List<String> orderIdList){
		//
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		
		PurchasedInfoMapper mapper = session.getMapper(PurchasedInfoMapper.class);

		List<PurchasedInfo> purchasedInfoList = mapper.retrievePurchasedCountByMonth(orderIdList);
		
		session.close();

		return purchasedInfoList;
		
	}



	@Override
	public List<PurchasedInfo> retrieveAllByOrderId(String orderId) {

		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		PurchasedInfoMapper mapper = session.getMapper(PurchasedInfoMapper.class);

		List<PurchasedInfo> purchasedInfoList = mapper.retrieveAllByOrderId(orderId);
		session.close();
		return purchasedInfoList;
	}

	
	

	@Override
	public int countByBook(PurchasedInfo purchasedInfo) {
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();

		PurchasedInfoMapper mapper = session.getMapper(PurchasedInfoMapper.class);
		int count = mapper.countByBook(purchasedInfo);
		session.close();
		return count;
	}

	@Override
	public void createPurchasedInfo(List<PurchasedInfo> purchasedInfoList) {
		// TODO Auto-generated method stub

		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		
		PurchasedInfoMapper mapper = session.getMapper(PurchasedInfoMapper.class);

		for (PurchasedInfo purchasedInfo : purchasedInfoList) {
			mapper.createPurchasedInfo(purchasedInfo);
		}
		
		session.close();
	}

	@Override
	public String checkPurchasedInfoIdByOrderIdMemberId(HashMap<String, String> map) {
		
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		
		PurchasedInfoMapper mapper = session.getMapper(PurchasedInfoMapper.class);
		
		String purchasedInfoId = mapper.checkPurchasedInfoIdByOrderIdMemberId(map);
		
		session.close();
		
		return purchasedInfoId;
	}
}
