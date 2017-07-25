package book.dao.mapper;

import java.util.HashMap;
import java.util.List;

import book.domain.PurchasedInfo;

public interface PurchasedInfoMapper {

	public int getLastOrderNumber();

	public void create(PurchasedInfo purchasedInfo);

	public List<PurchasedInfo> retrieveAllByBookId(String bookId);

	public List<PurchasedInfo> retrieveByMemberId(String memberId);

	public List<PurchasedInfo> retrieveByOrderNumber(String orderNumber);

	public Integer retrievePurchasedCount(String orderId);

	public List<PurchasedInfo> retrievePurchasedCountByMonth(List<String> orderIdList);
	
	public List<PurchasedInfo> retrieveAllByOrderId(String orderId);

	public int countByBook(PurchasedInfo purchasedInfo);

	public void createPurchasedInfo(PurchasedInfo purchasedInfo);

	public String checkPurchasedInfoIdByOrderIdMemberId(HashMap<String, String> map);
}
