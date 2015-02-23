package pl.cudlax.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.cudlax.dao.ProductDAO;
import pl.cudlax.domain.Product;

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private SessionFactory sf;
	
	@Override
	public void createProduct(Product p) {
		Session s = sf.openSession();
		Transaction tr = s.getTransaction();
		tr.begin();
		s.save(p);
		tr.commit();
		s.close();
	}

	@Override
	public void updateProduct(Product p) {
		Session s = sf.openSession();
		Transaction tr = s.getTransaction();
		tr.begin();
		s.update(p);
		tr.commit();
		s.close();
	}

	@Override
	public void removeProduct(Product p) {
		Session s = sf.openSession();
		Transaction tr = s.getTransaction();
		tr.begin();
		s.delete(p);
		tr.commit();
		s.close();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProducts() {
		Session s = sf.openSession();
		List<Product> l = s.createQuery("FROM Product").list();
		s.close();
		return l;
	}

	@Override
	public Product getProduct(Long productID) {
		Session s = sf.openSession();
		Object o = s.get(Product.class, productID);
		s.close();
		return (Product) o;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProducts(String name) {
		Session s = sf.openSession();
		List<Product> l = s.createQuery("FROM Product WHERE Name = '" + name + "'").list();
		s.close();
		return l;
	}

	@Override
	public Product getProduct(String name) {
		Session s = sf.openSession();
		Product p = (Product)s.createCriteria(Product.class).add(Restrictions.eq("name", name)).uniqueResult();
		s.close();
		return p;
	}

}
