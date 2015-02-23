package pl.cudlax.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.cudlax.dao.OrderDAO;
import pl.cudlax.domain.Order;

@Repository
@Transactional
public class OrderDAOImpl implements OrderDAO {
	@Autowired
	private SessionFactory sf;

	@Override
	public void createOrder(Order c) {
		Session s = sf.openSession();
		Transaction tr = s.getTransaction();
		tr.begin();
		s.save(c);
		tr.commit();
		s.close();
	}

	@Override
	public void removeOrder(Order c) {
		Session s = sf.openSession();
		Transaction tr = s.getTransaction();
		tr.begin();
		s.delete(c);
		tr.commit();
		s.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getAllOrders() {
		Session s = sf.openSession();
		List<Order> l = s.createQuery("FROM Order").list();
		s.close();
		return l;
	}

	@Override
	public Order getOrder(Long id) {
		Session s = sf.openSession();
		Order found = (Order) s.createCriteria(Order.class)
				.add(Restrictions.eq("orderId", id)).uniqueResult();
		s.close();
		return found;
	}

}
