package com.ahao.mysql.service.impl;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.ahao.mysql.dao.IQueryDao;
import com.ahao.mysql.pojo.LikePojo;
import com.ahao.mysql.service.IQueryService;
import com.ahao.mysql.tool.ErrorcodeEnum;
import com.ahao.mysql.tool.ResultUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Service
public class QueryServiceImpl implements IQueryService {
    @Resource
    IQueryDao iQueryDao;

    @Override
    public JSONObject queryListNormal() {
        JSONArray queryListNormal = iQueryDao.queryListNormal();
        return ResultUtil.jsonResultList(ErrorcodeEnum.SUCCESS.getErrorcode(), 
                ErrorcodeEnum.SUCCESS.getDescribe(), queryListNormal);
    }
    
    @Override
    public JSONObject transactional(JSONObject jsonParam) {
        LikePojo likePojo = JSONObject.toJavaObject(jsonParam, LikePojo.class);
        JSONArray transactional = new JSONArray();
        try {
            transactional = iQueryDao.transactional(likePojo);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return ResultUtil.jsonResultList(ErrorcodeEnum.SUCCESS.getErrorcode(), 
                ErrorcodeEnum.SUCCESS.getDescribe(), transactional);
    }
}
