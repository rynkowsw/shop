package pl.cudlax.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.cudlax.dao.EmployeeDAO;
import pl.cudlax.domain.Employee;
@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private SessionFactory sf;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployees() {
		Session s = sf.openSession();
		List<Employee> l = s.createQuery("FROM Employee WHERE Type = '" + Employee.EmployeeType.WORKER + "' ORDER BY Name").list();
		s.close();
		return l;
	}

	@Override
	public void updateEmployee(Employee c) {
		Session s = sf.openSession();
		Transaction tr = s.getTransaction();
		tr.begin();
		s.update(c);
		tr.commit();
		s.close();
	}

	@Override
	public void addEmployee(Employee c) {
		Session s = sf.openSession();
		Transaction tr = s.getTransaction();
		tr.begin();
		s.save(c);
		tr.commit();
		s.close();
	}

	@Override
	public void removeEmployee(Employee c) {
		Session s = sf.openSession();
		Transaction tr = s.getTransaction();
		tr.begin();
		s.delete(c);
		tr.commit();
		s.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getClients() {
		Session s = sf.openSession();
		List<Employee> l = s.createQuery("FROM Employee WHERE Type = '" + Employee.EmployeeType.CLIENT + "' ORDER BY Name").list();
		s.close();
		return l;
	}

	@Override
	public void updateClient(Employee c) {
		updateEmployee(c);
		
	}

	@Override
	public void addClient(Employee c) {
		addEmployee(c);
	}

	@Override
	public void removeClient(Employee c) {
		removeEmployee(c);
	}
}
