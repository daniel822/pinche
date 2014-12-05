package com.pinche.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 所有dao实现类继承它
 */
public class BaseDao {
	
	@Resource
	private JdbcTemplate jdbcTemplate;// spring 提供的jdbc操作辅助类

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	
}
