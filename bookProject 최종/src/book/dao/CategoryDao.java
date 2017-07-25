package book.dao;

import java.util.List;

import book.domain.Category;

public interface CategoryDao {

	Category retrieveByCategoryId(String categoryId);
	
	List<Category> retrieveAll();
}
