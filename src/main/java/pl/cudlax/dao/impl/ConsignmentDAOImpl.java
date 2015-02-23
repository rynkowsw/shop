package pl.cudlax.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.cudlax.dao.ConsignmentDAO;
import pl.cudlax.domain.Consignment;
@Repository
public class ConsignmentDAOImpl implements ConsignmentDAO {
	@Autowired
	private SessionFactory sf;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Consignment> getConsigmnentList() {
		Session s = sf.openSession();
		
		List<Consignment> l = s.createQuery("FROM Consignment").list();
		s.close();
		return l;
	}

	@Override
	@Transactional
	public Consignment getConsignment(Long consignmentID) {
		Session s = sf.openSession();
		Object o = s.get(Consignment.class, consignmentID);
		return (Consignment)o;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Consignment> getConsingments(boolean isActive) {
		Session s = sf.openSession();
		List<Consignment> l = s.createQuery("FROM Consignment WHERE Active = " + (isActive ? 1 : 0)).list();
		s.close();
		return l;
	}

	@Override
	@Transactional
	public void updateConsignment(Consignment c) {
		Session s = sf.openSession();
		Transaction tr = s.getTransaction();
		tr.begin();
		s.update(c);
		tr.commit();
		s.close();
	}

	@Override
	@Transactional
	public void createConsignment(Consignment c) {
		Session s = sf.openSession();
		Transaction tr = s.getTransaction();
		tr.begin();
		s.save(c);
		tr.commit();
		s.close();
	}

	@Override
	@Transactional
	public void removeConsignment(Consignment c) {
		Session s = sf.openSession();
		Transaction tr = s.getTransaction();
		tr.begin();
		s.delete(c);
		tr.commit();
		s.close();
	}

}
