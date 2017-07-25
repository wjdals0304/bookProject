package book.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import book.dao.BasketItemDao;
import book.dao.BookMybatisSessionFactoy;
import book.dao.mapper.BasketItemMapper;
import book.domain.BasketItem;

public class BasketItemDaoLogic implements BasketItemDao {

	@Override
	public void create(BasketItem basketItem) {

		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		
		BasketItemMapper mapper = session.getMapper(BasketItemMapper.class);
		
		mapper.create(basketItem);
		
		session.close();
	}
	
	@Override
	public void update(BasketItem basketItem) {
		
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		
		BasketItemMapper mapper = session.getMapper(BasketItemMapper.class);	
		
		mapper.update(basketItem);
		
		session.close();
	}

	@Override
	public void delete(String basketItemId) {

		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		
		BasketItemMapper mapper = session.getMapper(BasketItemMapper.class);
		
		mapper.delete(basketItemId);
		
		session.close();
	}
	
	@Override
	public List<BasketItem> retrieveAllByBasketId(String basketId) {

		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		
		BasketItemMapper mapper = session.getMapper(BasketItemMapper.class);
		
		List<BasketItem> basketItemList = mapper.retrieveAllByBasketId(basketId);
		
		session.close();
		
		return basketItemList;
	}

	@Override
	public List<String> removeBasketItemWithLogin(String basketId) {

		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		
		BasketItemMapper mapper = session.getMapper(BasketItemMapper.class);
		
		List<String> basketItemIdList = mapper.removeBasketItemWithLogin(basketId);
		
		session.close();
		
		return basketItemIdList;
	}

}
