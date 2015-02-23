package pl.cudlax.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.cudlax.dao.ProductionDAO;
import pl.cudlax.domain.Product;
import pl.cudlax.domain.Production;

@Repository
public class ProductionDAOImpl implements ProductionDAO {
	@Autowired
	private SessionFactory sf;
	
	@Override
	@Transactional
	public void addProduction(Production p) {
		Session s = sf.openSession();
		Transaction tr = s.getTransaction();
		tr.begin();
		s.save(p);
		tr.commit();
		s.close();
	}

	@Override
	@Transactional
	public void removeProduction(Production p) {
		Session s = sf.openSession();
		Transaction tr = s.getTransaction();
		tr.begin();
		s.delete(p);
		tr.commit();
		s.close();
	}

	@Override
	@Transactional
	public void updateProduction(Production p) {
		Session s = sf.openSession();
		Transaction tr = s.getTransaction();
		tr.begin();
		s.update(p);
		tr.commit();
		s.close();
	}

	@Override
	@Transactional
	public List<Product> getProductList() {
		Session s = sf.openSession();
		List l = s.createQuery("FROM Product AS P WHERE EXISTS (FROM Production AS PR WHERE PR.ProductId = P.ProductId)").list();
		s.close();
		return l;
	}

	@Override
	@Transactional
	public List<Production> getProductions() {
		Session s = sf.openSession();
		List l = s.createQuery("FROM Production").list();
		s.close();
		return l;
	}
}
