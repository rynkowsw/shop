package pl.cudlax.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.cudlax.dao.ProductionDAO;
import pl.cudlax.domain.Product;
import pl.cudlax.domain.Production;
import pl.cudlax.service.ProductionService;
@Service
public class ProductionServiceImpl implements ProductionService {
	@Autowired
	ProductionDAO dao;

	@Override
	public void addProduction(Production p) {
		dao.addProduction(p);
	}

	@Override
	public void removeProduction(Production p) {
		dao.removeProduction(p);
	}

	@Override
	public void updateProduction(Production p) {
		dao.updateProduction(p);
	}

	@Override
	public List<Product> getProductList() {
		return dao.getProductList();
	}

	@Override
	public List<Production> getProductions() {
		return dao.getProductions();
	}
	

}
