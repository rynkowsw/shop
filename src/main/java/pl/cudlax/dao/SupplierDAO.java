package pl.cudlax.dao;

import java.util.List;

import pl.cudlax.domain.Supplier;

public interface SupplierDAO {
	Supplier getSupplier(String name);
	
	Supplier getSupplier(Long supplierID);
	
	List<Supplier> getSuppliers();
	
	void createSupplier(Supplier s);
	
	void updateSupplier(Supplier s);
	
	void removeSupplier(Supplier s);
}
