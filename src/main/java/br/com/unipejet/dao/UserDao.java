package br.com.unipejet.dao;

import java.util.List;

import br.com.unipejet.entity.User;

public interface UserDao {

	User findById(int id);

	User findByLogin(String login);

	void save(User user);

	void deleteByLogin(String login);

	List<User> findAllUsers();
}
