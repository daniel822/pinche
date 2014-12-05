package com.pinche.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pinche.model.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet set, int index) throws SQLException {
		User user = new User();
		user.setId(set.getLong("id"));
		user.setUserName(set.getString("username"));
		return user;
	}

}
