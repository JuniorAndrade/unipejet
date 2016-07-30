package br.com.unipejet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.unipejet.dao.UserDao;
import br.com.unipejet.entity.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public User findById(int id) {
		return dao.findById(id);
	}

	public User findByLogin(String login) {
		User user = dao.findByLogin(login);
		return user;
	}

	public void saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.save(user);
	}

	public void updateUser(User user) {
		User entity = dao.findById(user.getId());
		if(entity!=null){
			entity.setLogin(user.getLogin());
			if(!user.getPassword().equals(entity.getPassword())){
				entity.setPassword(passwordEncoder.encode(user.getPassword()));
			}
			entity.setName(user.getName());
			entity.setEmail(user.getEmail());
			entity.setUserProfiles(user.getUserProfiles());
		}
	}

	public void deleteUserByLogin(String login) {
		dao.deleteByLogin(login);
	}

	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	public boolean isUserLoginUnique(Integer id, String login) {
		User user = findByLogin(login);
		return ( user == null || ((id != null) && (user.getId() == id)));
	}

}
