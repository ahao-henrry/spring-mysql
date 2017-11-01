package com.ahao.mysql.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ahao.mysql.dao.IQueryDao;
import com.ahao.mysql.pojo.LikePojo;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Repository
@Transactional
public class QueryDaoImpl implements IQueryDao {
    @Resource
    JdbcTemplate jdbcTemplate;
    @Resource
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Override
    public JSONArray queryListNormal() {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from like_table");
        final JSONArray jsonArrayResult = new JSONArray();
        
        RowCallbackHandler rowCallbackHandler = new RowCallbackHandler() {
            
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                JSONObject jsonResult = new JSONObject();
                jsonResult.put("userId", rs.getString("userId"));
                jsonResult.put("userName", rs.getString("userName"));
                jsonResult.put("sports", rs.getString("sports"));
                jsonResult.put("fruits", rs.getString("fruits"));
                jsonArrayResult.add(jsonResult);
            }
        };
        try {
            jdbcTemplate.query(sql.toString(), rowCallbackHandler);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return jsonArrayResult;
    }
    
    @Override
    public JSONArray transactional(LikePojo likePojo) throws DataAccessException{
        insertTran(likePojo);
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("select * from like_table");
        final JSONArray jsonArrayResult = new JSONArray();
        RowCallbackHandler rowCallbackHandler = new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                JSONObject jsonResult = new JSONObject();
                jsonResult.put("userId", rs.getString("userId"));
                jsonResult.put("userName", rs.getString("userName"));
                jsonResult.put("sports", rs.getString("sports"));
                jsonResult.put("fruits", rs.getString("fruits"));
                jsonArrayResult.add(jsonResult);
            }
        };
        jdbcTemplate.query(sqlQuery.toString(), rowCallbackHandler);
        return jsonArrayResult;
    }
    
    public void insertTran(LikePojo likePojo) {
        StringBuilder sqlInsert = new StringBuilder();
        sqlInsert.append("insert into like_table(userId,userName,fruits,sports) values(?,?,?,?)");
        Object[] params = {likePojo.getUserId(), likePojo.getUserName(), likePojo.getFruits(), likePojo.getSports()};
        jdbcTemplate.update(sqlInsert.toString(), params);
    }
}
