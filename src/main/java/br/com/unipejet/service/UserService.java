package br.com.unipejet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.unipejet.entity.User;

@Service
public interface UserService {
	
	User findById(int id);
	
	User findByLogin(String login);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserByLogin(String login);

	List<User> findAllUsers(); 
	
	boolean isUserLoginUnique(Integer id, String login);

}
