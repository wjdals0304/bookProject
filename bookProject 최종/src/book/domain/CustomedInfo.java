package book.domain;

import java.sql.Date;

public class CustomedInfo {

	private String memberId;
	private Date regDate;
	
	private Book book;
	
	public CustomedInfo() {
		super();
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	@Override
	public String toString() {
		return "CustomedInfo [memberId=" + memberId + ", regDate=" + regDate + ", book=" + book + "]";
	}

}
