package pl.cudlax.dao;

import java.util.List;

import pl.cudlax.domain.Category;
import pl.cudlax.domain.Product;

public interface CategoryDAO {
	void createCategory(Category c);
	void removeCategory(Category c);
	List<Category> getAllCategories();
	
	List<Product> getAllProductsAsigneeToCategory(Category c);
	
	Category getCategory(String name);
}
