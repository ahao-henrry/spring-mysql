package com.ahao.mysql.dao;

import org.springframework.dao.DataAccessException;

import com.ahao.mysql.pojo.LikePojo;
import com.alibaba.fastjson.JSONArray;

public interface IQueryDao {

    JSONArray queryListNormal();

    JSONArray transactional(LikePojo likePojo) throws DataAccessException;

}
