package pl.cudlax.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.cudlax.dao.SupplierDAO;
import pl.cudlax.domain.Supplier;
@Service
public class SupplierServiceImpl implements SupplierDAO {
	@Autowired
	SupplierDAO dao;
	
	@Override
	public Supplier getSupplier(String name) {
		return dao.getSupplier(name);
	}

	@Override
	public Supplier getSupplier(Long supplierID) {
		return dao.getSupplier(supplierID);
	}

	@Override
	public List<Supplier> getSuppliers() {
		return dao.getSuppliers();
	}

	@Override
	public void createSupplier(Supplier s) {
		dao.createSupplier(s);
	}

	@Override
	public void updateSupplier(Supplier s) {
		dao.updateSupplier(s);
	}

	@Override
	public void removeSupplier(Supplier s) {
		dao.removeSupplier(s);
	}

}
