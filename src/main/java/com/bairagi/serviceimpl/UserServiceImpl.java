package com.bairagi.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bairagi.common.User;
import com.bairagi.dao.UserDAO;
import com.bairagi.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
	
	public void createUser(User user) {
		
		userDAO.createUser(user);
		
	}


	public User getUser(int id) {
		
		return userDAO.getUser(id);
	}


	public List<User> getAllUser() {
		
		return userDAO.getAllUser();
	}


	public User updateUser(int id, User user) {
		return userDAO.updateUser(id,user);
		
	}
	public void deleteUser(int id){
		userDAO.deleteUser(id);
	}

}
