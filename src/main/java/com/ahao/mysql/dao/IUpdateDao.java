package com.ahao.mysql.dao;

public interface IUpdateDao {

    boolean updateNormal(String userId, String sports, String fruits);

	boolean batchUpdate(String sports, String newSports);

}
