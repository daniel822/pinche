package com.pinche.dao;

import org.springframework.stereotype.Repository;

import com.pinche.model.User;
import com.pinche.rowmapper.UserRowMapper;

@Repository
public class UserDaoImpl extends BaseDao implements UserDao{

	@Override
	public User getUser(long id) {
		return getJdbcTemplate().queryForObject("select * from test_user where id=?", new Object[]{id}, new UserRowMapper());
	}

	@Override
	public int delUser(long id) {
		return getJdbcTemplate().update("delete from test_user where id = ?", new Object[]{id});
	}

	@Override
	public int addUser(User user) {
		return getJdbcTemplate().update("insert into test_user(id,username)values(?,?)", new Object[]{user.getId(),user.getUserName()});
	}

	
}
