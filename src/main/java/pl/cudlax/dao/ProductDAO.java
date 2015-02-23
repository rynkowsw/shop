package pl.cudlax.dao;

import java.util.List;

import pl.cudlax.domain.Product;

public interface ProductDAO {
	void createProduct(Product p);
	
	void updateProduct(Product p);
	
	void removeProduct(Product p);
	
	List<Product> getProducts();
	
	Product getProduct(Long productID);
	
	List<Product> getProducts(String name);
	
	Product getProduct(String name);
}
