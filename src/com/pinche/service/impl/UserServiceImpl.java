package com.pinche.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pinche.dao.UserDao;
import com.pinche.model.User;
import com.pinche.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	
	@Override
	public User getUser(long id) {
		return userDao.getUser(id);
	}

	@Override
	public int delUser(long id) {
		return userDao.delUser(id);
	}

	@Override
	public int addUser(User user) {
		return userDao.addUser(user);
	}

}
