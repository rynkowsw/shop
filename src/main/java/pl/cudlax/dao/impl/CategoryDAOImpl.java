package pl.cudlax.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.cudlax.dao.CategoryDAO;
import pl.cudlax.domain.Category;
import pl.cudlax.domain.Product;
@Repository
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	private SessionFactory sf;
	
	@Override
	public void createCategory(Category c) {
		Session s = sf.openSession();
		Transaction tr = s.getTransaction();
		tr.begin();
		s.save(c);
		tr.commit();
		s.close();
	}

	@Override
	public void removeCategory(Category c) {
		Session s = sf.openSession();
		Transaction tr = s.getTransaction();
		tr.begin();
		s.delete(c);
		tr.commit();
		s.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategories() {
		Session s = sf.openSession();
		List<Category> l = s.createQuery("FROM Category").list();
		s.close();
		return l;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProductsAsigneeToCategory(Category c) {
		Session s = sf.openSession();
		Query q = s.createQuery("FROM Product WHERE Category_Id = " + c.getCategoryId());

		List<Product> l = q.list();
		s.close();
		return l;
	}

	@Override
	public Category getCategory(String name) {
		Session s = sf.openSession();
		Category found = (Category) s.createCriteria(Category.class).add(Restrictions.eq("name", name)).uniqueResult();
		s.close();
		return found;
	}

}
