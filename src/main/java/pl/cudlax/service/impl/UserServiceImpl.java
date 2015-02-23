package pl.cudlax.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.cudlax.dao.UserDAO;
import pl.cudlax.domain.User;
import pl.cudlax.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO dao;
	@Override
	public void createUser(User u) {
		dao.createUser(u);
	}

	@Override
	public void updateUser(User u) {
		dao.updateUser(u);
	}

	@Override
	public void removeUser(User u) {
		dao.removeUser(u);
	}

	@Override
	public User getUser(String login) {
		return dao.getUser(login);
	}

	@Override
	public User getUserByMail(String email) {
		return dao.getUserByMail(email);
	}

	@Override
	public User getUser(Long id) {
		return dao.getUser(id);
	}

}
