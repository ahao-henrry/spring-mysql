package com.ahao.mysql.dao.impl;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ahao.mysql.dao.IAddDao;
import com.ahao.mysql.pojo.LikePojo;

@Repository
public class AddDaoImpl implements IAddDao {
    @Resource
    JdbcTemplate jdbcTemplate;
    @Resource 
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public boolean saveNormal(LikePojo likePojo) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into like_table(userId,userName,fruits,sports) values(?,?,?,?)");
        
        Object[] params = {likePojo.getUserId(), likePojo.getUserName(), likePojo.getFruits(), likePojo.getSports()};
        try {
            jdbcTemplate.update(sql.toString(), params);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    @Override
    public boolean saveNamedParameter(LikePojo likePojo) {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into like_table(userId,userName,fruits,sports) ");
        sql.append("values(:userId,:userName,:fruits,:sports) ");
        
        SqlParameterSource source = new BeanPropertySqlParameterSource(likePojo);
        try {
            namedParameterJdbcTemplate.update(sql.toString(), source);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
