package book.dao.mybatis;

import org.apache.ibatis.session.SqlSession;

import book.dao.BookMybatisSessionFactoy;
import book.dao.MemberDao;
import book.dao.mapper.MemberMapper;
import book.domain.Member;

public class MemberDaoLogic implements MemberDao {

	@Override
	public Member loginCheck(String loginId) {
		//
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		
		Member member = mapper.loginCheck(loginId);
		
		session.close();
		
		return member;
	}

	@Override
	public String checkLoginId(String loginId) {
		//
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		
		String id = mapper.checkLoginId(loginId);

		session.close();
		
		return id;
	}

	@Override
	public void create(Member member) {
		//
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		
		mapper.create(member);
		
		session.close();
	}

	@Override
	public void update(Member member) {
		//
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		
		mapper.update(member);
		
		session.close();
	}
}
