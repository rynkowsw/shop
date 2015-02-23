package pl.cudlax.dao;

import java.util.List;

import pl.cudlax.domain.Product;
import pl.cudlax.domain.Production;

public interface ProductionDAO {
	void addProduction(Production p);
	
	void removeProduction(Production p);
	
	void updateProduction(Production p);
	// metoda pobiera listê wszystkich produkowanych produktów
	List<Product> getProductList();
	
	List<Production> getProductions();
}
