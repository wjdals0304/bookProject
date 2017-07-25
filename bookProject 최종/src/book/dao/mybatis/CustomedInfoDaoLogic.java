package book.dao.mybatis;


import org.apache.ibatis.session.SqlSession;

import book.dao.BookMybatisSessionFactoy;
import book.dao.CustomedInfoDao;
import book.dao.mapper.CustomedInfoMapper;
import book.domain.CustomedInfo;

public class CustomedInfoDaoLogic implements CustomedInfoDao{

	@Override
	public void create(CustomedInfo customedInfo) {
		//
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		
		CustomedInfoMapper mapper = session.getMapper(CustomedInfoMapper.class);
		
		mapper.create(customedInfo);
		
		session.close();
		
	}

	@Override
	public void update(CustomedInfo customedInfo) {
		//
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		
		CustomedInfoMapper mapper = session.getMapper(CustomedInfoMapper.class);
		
		mapper.update(customedInfo);
		
		session.close();
		
	}

	@Override
	public CustomedInfo retrieveByMemberId(String memberId) {
		//
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		
		CustomedInfoMapper mapper = session.getMapper(CustomedInfoMapper.class);
		
		CustomedInfo customedInfo = mapper.retrieveByMemberId(memberId);
		
		session.close();
		
		return customedInfo;
		
	}


}
