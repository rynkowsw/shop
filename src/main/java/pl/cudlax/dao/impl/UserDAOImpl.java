package pl.cudlax.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.cudlax.dao.UserDAO;
import pl.cudlax.domain.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sf;

	@Override
	@Transactional
	public void createUser(User u) {
		Session ses = sf.openSession();
		Transaction tr = ses.getTransaction();
		tr.begin();
		ses.save(u);
		tr.commit();
		ses.close();
	}

	@Override
	@Transactional
	public void updateUser(User u) {
		Session ses = sf.openSession();
		Transaction tr = ses.getTransaction();
		tr.begin();
		ses.update(u);
		tr.commit();
		ses.close();
	}

	@Override
	@Transactional
	public void removeUser(User u) {
		Session ses = sf.openSession();
		Transaction tr = ses.getTransaction();
		tr.begin();
		ses.delete(u);
		tr.commit();
		ses.close();
	}

	@Override
	@Transactional
	public User getUser(String login) {
		Session s = sf.openSession();
		Object o = s.createQuery("FROM User Where login = '" + login + "'")
				.uniqueResult();
		s.close();
		return (User) o;
	}

	@Override
	@Transactional
	public User getUserByMail(String email) {
		Session s = sf.openSession();
		User o = (User) s
				.createQuery("FROM User Where email = '" + email + "'")
				.uniqueResult();
		s.close();
		return o;
	}

	@Override
	@Transactional
	public User getUser(Long id) {
		Session s = sf.openSession();
		Object o = s.get(User.class, id);
		s.close();
		return (User) o;
	}

}
