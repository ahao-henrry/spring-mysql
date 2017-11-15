package com.ahao.mysql.dao.impl;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ahao.mysql.dao.IDeleteDao;

@Repository
public class DeleteDaoImpl implements IDeleteDao {
	@Resource
    JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean delete(String id) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from like_table where userId=?");
		Object[] params = {id};
		try {
			jdbcTemplate.update(sql.toString(), params);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
