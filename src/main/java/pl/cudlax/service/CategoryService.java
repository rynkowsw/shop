package pl.cudlax.service;

import java.util.List;

import pl.cudlax.domain.Category;

public interface CategoryService {
	void createCategory(Category c);
	void removeCategory(Category c);
	List<Category> getAllCategories();
	
	boolean isCategoryExists(String name);
}
