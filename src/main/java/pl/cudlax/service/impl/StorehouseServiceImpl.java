package pl.cudlax.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.cudlax.dao.StorehouseDAO;
import pl.cudlax.domain.Product;
import pl.cudlax.domain.Storehouse;
import pl.cudlax.service.StorehouseService;
@Service
public class StorehouseServiceImpl implements StorehouseService {
	@Autowired
	StorehouseDAO dao;
	@Override
	public void createStorehouseItem(Storehouse sh) {
		dao.createStorehouseItem(sh);
	}

	@Override
	public void removeStorehouseItem(Storehouse sh) {
		dao.removeStorehouseItem(sh);
	}

	@Override
	public void updateStorehouseItem(Storehouse sh) {
		dao.updateStorehouseItem(sh);
	}

	@Override
	public List<Product> getProductsInStorehouse() {
		return dao.getProductsInStorehouse();
	}

	@Override
	public Storehouse getStorehouseItem(Long storehouseID) {
		return dao.getStorehouseItem(storehouseID);
	}

}
