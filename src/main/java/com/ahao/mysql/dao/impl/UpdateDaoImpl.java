package com.ahao.mysql.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ahao.mysql.dao.IUpdateDao;

@Repository
public class UpdateDaoImpl implements IUpdateDao {
    @Resource
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public boolean updateNormal(String userId, String sports, String fruits) {
        StringBuilder sqlUpdate = new StringBuilder();
        sqlUpdate.append("update like_table set sports=?,fruits=? where userId=?");
        Object[] params = {sports, fruits, userId};
        try {
            jdbcTemplate.update(sqlUpdate.toString(), params);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    @Override
    public boolean batchUpdate(final String sports, final String newSports) {
		StringBuilder querySql = new StringBuilder();
		querySql.append("select * from like_table where sports=?");
		Object[] params = {sports};
		final List<Map<String, Object>> listLikePojo = jdbcTemplate.queryForList(querySql.toString(), params);
		
		StringBuilder updateSql = new StringBuilder();
		updateSql.append("update like_table set fruits=? where sports=?");
		jdbcTemplate.batchUpdate(updateSql.toString(), new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement arg0, int arg1) throws SQLException {
				arg0.setString(1, newSports);
				arg0.setString(2, sports);
			}
			
			@Override
			public int getBatchSize() {				
				return listLikePojo.size();
			}
		});
		return true;
	}
}
