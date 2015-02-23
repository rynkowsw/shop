package pl.cudlax.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.cudlax.dao.StorehouseDAO;
import pl.cudlax.domain.Product;
import pl.cudlax.domain.Storehouse;
@Repository
public class StorehouseDAOImpl implements StorehouseDAO {
	@Autowired
	private SessionFactory sf;
	
	@Override
	@Transactional
	public void createStorehouseItem(Storehouse sh) {
		Session s = sf.openSession();
		Transaction tr = s.getTransaction();
		tr.begin();
		s.save(sh);
		tr.commit();
		s.close();
	}

	@Override
	@Transactional
	public void removeStorehouseItem(Storehouse sh) {
		Session s = sf.openSession();
		Transaction tr = s.getTransaction();
		tr.begin();
		s.delete(sh);
		tr.commit();
	}

	@Override
	@Transactional
	public void updateStorehouseItem(Storehouse sh) {
		Session s = sf.openSession();
		Transaction tr = s.getTransaction();
		tr.begin();
		s.update(sh);
		tr.commit();
		s.close();
	}

	@Override
	@Transactional
	public List<Product> getProductsInStorehouse() {
		Session s = sf.openSession();
		List l = s.createQuery("FROM Product AS P WHERE EXISTS (FROM Storehouse AS SH WHERE SH.ProductId = P.ProductId)").list();
		s.close();
		return l;
	}

	@Override
	@Transactional
	public Storehouse getStorehouseItem(Long storehouseID) {
		Session s = sf.openSession();
		Object o = s.get(Storehouse.class, storehouseID);
		s.close();
		return (Storehouse) o;
	}

}
