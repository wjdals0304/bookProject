package book.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import book.dao.BookMybatisSessionFactoy;
import book.dao.CategoryDao;
import book.dao.mapper.CategoryMapper;
import book.domain.Category;

public class CategoryDaoLogic implements CategoryDao {

	@Override
	public Category retrieveByCategoryId(String categoryId){
		//
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		
		CategoryMapper mapper = session.getMapper(CategoryMapper.class);
		
		Category category = mapper.retrieveByCategoryId(categoryId);
		
		session.close();
		
		return category;
		
	}

	@Override
	public List<Category> retrieveAll(){
		//
		SqlSession session = BookMybatisSessionFactoy.createInstance().getSqlSession();
		
		CategoryMapper mapper = session.getMapper(CategoryMapper.class);
		
		List <Category> categoryList = mapper.retrieveAll();
		
		session.close();
		
		return categoryList;
		
	}
}
