package pl.cudlax.dao;

import pl.cudlax.domain.User;

public interface UserDAO {
	void createUser(User u);
	
	void updateUser(User u);
	
	void removeUser(User u);
	
	User getUser(String login);
	User getUserByMail(String email);
	User getUser(Long id);
}
