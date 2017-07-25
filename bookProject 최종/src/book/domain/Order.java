package book.domain;

import java.sql.Date;
import java.util.List;

public class Order {

	private String orderId;
	private Date orderDate;
	private String memberId;
	
	private int totalPrice; 
	private List<PurchasedInfo> purchasedInfoList;
	
	public Order() {
		super();
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public List<PurchasedInfo> getPurchasedInfoList() {
		return purchasedInfoList;
	}

	public void setPurchasedInfoList(List<PurchasedInfo> purchasedInfoList) {
		this.purchasedInfoList = purchasedInfoList;
	}


	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

}
