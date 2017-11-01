package com.ahao.mysql.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ahao.mysql.dao.IUpdateDao;
import com.ahao.mysql.service.IUpdateService;
import com.ahao.mysql.tool.ErrorcodeEnum;
import com.ahao.mysql.tool.ResultUtil;
import com.alibaba.fastjson.JSONObject;

@Service
public class UpdateServiceImpl implements IUpdateService {
    @Resource
    private IUpdateDao iUpdateDao;
    
    @Override
    public JSONObject updateNormal(JSONObject jsonParam) {
        String userId = jsonParam.getString("userId");
        String sports = jsonParam.getString("sports");
        String fruits = jsonParam.getString("fruits");
        if (null == userId || "".equals(userId) || null == sports || "".equals(sports) 
                || null == fruits || "".equals(fruits)) {
            return ResultUtil.jsonResultBasic(ErrorcodeEnum.PARAMS_ERROR.getErrorcode(), 
                    ErrorcodeEnum.PARAMS_ERROR.getDescribe(), false);
        }
        
        boolean updateNormal = iUpdateDao.updateNormal(userId, sports, fruits);
        if (false == updateNormal) {
            return ResultUtil.jsonResultBasic(ErrorcodeEnum.SERVER_ERROR.getErrorcode(), 
                    ErrorcodeEnum.SERVER_ERROR.getDescribe(), false);
        }
        return ResultUtil.jsonResultBasic(ErrorcodeEnum.SUCCESS.getErrorcode(), 
                ErrorcodeEnum.SUCCESS.getDescribe(), true);
    }
    
    @Override
    public JSONObject batchUpdate(JSONObject jsonParam) {
        String sports = jsonParam.getString("sports");
        String newSports = jsonParam.getString("newSports");
        if (null == sports || "".equals(sports) || null == newSports || "".equals(newSports)) {
            return ResultUtil.jsonResultBasic(ErrorcodeEnum.PARAMS_ERROR.getErrorcode(), 
                    ErrorcodeEnum.PARAMS_ERROR.getDescribe(), false);
        }
        
        boolean batchUpdate = iUpdateDao.batchUpdate(sports, newSports);
        if (false == batchUpdate) {
            return ResultUtil.jsonResultBasic(ErrorcodeEnum.SERVER_ERROR.getErrorcode(), 
                    ErrorcodeEnum.SERVER_ERROR.getDescribe(), false);
        }
        return ResultUtil.jsonResultBasic(ErrorcodeEnum.SUCCESS.getErrorcode(), 
                ErrorcodeEnum.SUCCESS.getDescribe(), true);
	}
}
