package book.dao.mapper;

import java.util.List;

import book.domain.Category;

public interface CategoryMapper {
	
	Category retrieveByCategoryId(String categoryId);
	
	List<Category> retrieveAll();
	
}
