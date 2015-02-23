package pl.cudlax.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.cudlax.dao.SupplierDAO;
import pl.cudlax.domain.Supplier;

@Repository
public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	private SessionFactory sf;
	
	@Override
	@Transactional
	public Supplier getSupplier(String name) {
		return null;
	}

	@Override
	@Transactional
	public Supplier getSupplier(Long supplierID) {
		Session s =  sf.openSession();
		Object o = s.get(Supplier.class, supplierID);
		s.close();
		return (Supplier) o;
	}

	@Override
	@Transactional
	public List<Supplier> getSuppliers() {
		Session s = sf.openSession();
		List l = s.createQuery("FROM Supplier").list();
		s.close();
		return l;
	}

	@Override
	@Transactional
	public void createSupplier(Supplier s) {
		Session ses = sf.openSession();
		Transaction tr = ses.getTransaction();
		tr.begin();
		ses.save(s);
		tr.commit();
		ses.close();
	}

	@Override
	@Transactional
	public void updateSupplier(Supplier s) {
		Session ses = sf.openSession();
		Transaction tr = ses.getTransaction();
		tr.begin();
		ses.update(s);
		tr.commit();
		ses.close();
	}

	@Override
	@Transactional
	public void removeSupplier(Supplier s) {
		Session ses = sf.openSession();
		Transaction tr = ses.getTransaction();
		tr.begin();
		ses.delete(s);
		tr.commit();
		ses.close();
	}

}
