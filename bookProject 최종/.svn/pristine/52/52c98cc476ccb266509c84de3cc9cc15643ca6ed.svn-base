package book.dao.mybatis;

import org.apache.ibatis.session.SqlSession;

import book.dao.BasketDao;
import book.dao.BookMybatisSessionFactoy;
import book.dao.mapper.BasketMapper;
import book.domain.Basket;

public class BasketDaoLogic implements BasketDao {

	@Override
	public void createBasket(String memberId) {
		
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		
		BasketMapper mapper = session.getMapper(BasketMapper.class);

		mapper.createBasket(memberId);
		
		session.close();
	}

	@Override
	public Basket retrieveByMemberId(String memberId) {

		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		
		BasketMapper mapper = session.getMapper(BasketMapper.class);
		
		Basket basket = mapper.retrieveByMemberId(memberId);
		
		session.close();
		
		return basket;
	}
}