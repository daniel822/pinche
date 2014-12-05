package com.pinche.dao;

import com.pinche.model.User;

public interface UserDao {

	public User getUser(long id);
	
	public int delUser(long id);
	
	public int addUser(User user);
}
