package pl.cudlax.dao;

import java.util.List;

import pl.cudlax.domain.Product;
import pl.cudlax.domain.Storehouse;

public interface StorehouseDAO {
	
	void createStorehouseItem(Storehouse sh);
	
	void removeStorehouseItem(Storehouse sh);
	
	void updateStorehouseItem(Storehouse sh);
	
	List<Product> getProductsInStorehouse();

	Storehouse getStorehouseItem(Long storehouseID);
}
