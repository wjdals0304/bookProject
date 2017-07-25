package book.dao;

import book.domain.CustomedInfo;

public interface CustomedInfoDao {
	
	void create(CustomedInfo customedInfo);
	void update(CustomedInfo customedInfo);
	CustomedInfo retrieveByMemberId(String memberId);
}
