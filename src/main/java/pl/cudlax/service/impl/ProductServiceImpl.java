package pl.cudlax.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.cudlax.dao.ProductDAO;
import pl.cudlax.domain.Product;
import pl.cudlax.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDAO dao;

	@Override
	public void createProduct(Product p) {
		dao.createProduct(p);
	}

	@Override
	public void updateProduct(Product p) {
		dao.updateProduct(p);
	}

	@Override
	public void removeProduct(Product p) {
		dao.removeProduct(p);
	}

	@Override
	public List<Product> getProducts() {
		return dao.getProducts();
	}

	@Override
	public Product getProduct(Long productID) {
		return dao.getProduct(productID);
	}

	@Override
	public List<Product> getProducts(String name) {
		return dao.getProducts(name);
	}

	@Override
	public boolean isProductExists(String name) {
		return dao.getProduct(name) != null;
	}
	
}
