package com.pinche.service;

import com.pinche.model.User;

public interface UserService {

	public User getUser(long id);
	
	public int delUser(long id);
	
	public int addUser(User user);
}
