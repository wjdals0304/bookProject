package book.dao;

import java.util.HashMap;
import java.util.List;

import book.domain.PurchasedInfo;

public interface PurchasedInfoDao {


	
	public Integer retrievePurchasedCount(String memberId);
	
	public List<PurchasedInfo> retrievePurchasedCountByMonth(List<String> orderIdList);
	
	// 주문번호로 구매리스트 가져오기
	public List<PurchasedInfo> retrieveAllByOrderId(String orderId);
	
	public int countByBook(PurchasedInfo purchasedInfo);
	
	public void createPurchasedInfo(List<PurchasedInfo> purchasedInfoList);

	public String checkPurchasedInfoIdByOrderIdMemberId(HashMap<String, String> map);
}
