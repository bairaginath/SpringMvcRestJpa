package com.bairagi.dao;

import java.util.List;

import com.bairagi.common.User;

public interface UserDAO {
	
	public void createUser(User user);
	public User getUser(int id);
	public List<User> getAllUser();
	public User updateUser(int id,User user);
	public void deleteUser(int id);

}
