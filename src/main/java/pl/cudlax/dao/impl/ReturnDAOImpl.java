package pl.cudlax.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.cudlax.dao.ReturnDAO;
import pl.cudlax.domain.Return;
@Repository
public class ReturnDAOImpl implements ReturnDAO {
	@Autowired
	private SessionFactory sf;
	
	@Override
	@Transactional
	public List<Return> getReturns() {
		Session s = sf.openSession();
		List l = s.createQuery("FROM Return").list();
		s.close();
		return l;
	}

	@Override
	@Transactional
	public Return getReturn(Long returnID) {
		Session s = sf.openSession();
		Object o = s.get(Return.class, returnID);
		s.close();
		return (Return) o;
	}

	@Override
	@Transactional
	public void createReturn(Return r) {
		Session s = sf.openSession();
		Transaction tr = s.getTransaction();
		tr.begin();
		s.save(r);
		tr.commit();
		s.close();
	}

	@Override
	@Transactional
	public void updateReturn(Return r) {
		Session s = sf.openSession();
		Transaction tr = s.getTransaction();
		tr.begin();
		s.update(r);
		tr.commit();
		s.close();
	}

	@Override
	@Transactional
	public void removeReturn(Return r) {
		Session s = sf.openSession();
		Transaction tr = s.getTransaction();
		tr.begin();
		s.delete(r);
		tr.commit();
		s.close();
	}

}
