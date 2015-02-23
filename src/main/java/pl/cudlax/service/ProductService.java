package pl.cudlax.service;

import java.util.List;

import pl.cudlax.domain.Product;

public interface ProductService {
	void createProduct(Product p);
	
	void updateProduct(Product p);
	
	void removeProduct(Product p);
	
	List<Product> getProducts();
	
	Product getProduct(Long productID);
	
	List<Product> getProducts(String name);
	
	boolean isProductExists(String name);
}
