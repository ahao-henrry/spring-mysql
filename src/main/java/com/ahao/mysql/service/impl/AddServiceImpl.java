package com.ahao.mysql.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ahao.mysql.dao.IAddDao;
import com.ahao.mysql.pojo.LikePojo;
import com.ahao.mysql.service.IAddService;
import com.ahao.mysql.tool.ErrorcodeEnum;
import com.ahao.mysql.tool.ResultUtil;
import com.alibaba.fastjson.JSONObject;

@Service
public class AddServiceImpl implements IAddService {
    @Resource
    IAddDao iaddDao;
    
    @Override
    public JSONObject saveNormal(JSONObject jsonParam) {
        if (null == jsonParam || null == jsonParam.getString("userId") || "".equals(jsonParam.getString("userId"))
            || null == jsonParam.getString("userName") || "".equals(jsonParam.getString("userName"))) {
            return ResultUtil.jsonResultBasic(ErrorcodeEnum.PARAMS_ERROR.getErrorcode(), 
                    ErrorcodeEnum.PARAMS_ERROR.getDescribe(), false);
        }
        LikePojo likePojo = JSONObject.toJavaObject(jsonParam, LikePojo.class);
        boolean saveNormal = iaddDao.saveNormal(likePojo);
        if (false == saveNormal) {
            return ResultUtil.jsonResultBasic(ErrorcodeEnum.SERVER_ERROR.getErrorcode(), 
                    ErrorcodeEnum.SERVER_ERROR.getDescribe(), false);
        }
        return ResultUtil.jsonResultBasic(ErrorcodeEnum.SUCCESS.getErrorcode(), 
                ErrorcodeEnum.SUCCESS.getDescribe(), true);
    }
    
    @Override
    public JSONObject saveNamedParameter(JSONObject jsonParam) {
        if (null == jsonParam || null == jsonParam.getString("userId") || "".equals(jsonParam.getString("userId"))
            || null == jsonParam.getString("userName") || "".equals(jsonParam.getString("userName"))) {
            return ResultUtil.jsonResultBasic(ErrorcodeEnum.PARAMS_ERROR.getErrorcode(), 
                    ErrorcodeEnum.PARAMS_ERROR.getDescribe(), false);
        }
        LikePojo likePojo = JSONObject.toJavaObject(jsonParam, LikePojo.class);
        boolean saveNormal = iaddDao.saveNamedParameter(likePojo);
        if (false == saveNormal) {
            return ResultUtil.jsonResultBasic(ErrorcodeEnum.SERVER_ERROR.getErrorcode(), 
                    ErrorcodeEnum.SERVER_ERROR.getDescribe(), false);
        }
        return ResultUtil.jsonResultBasic(ErrorcodeEnum.SUCCESS.getErrorcode(), 
                ErrorcodeEnum.SUCCESS.getDescribe(), true);
    }
}
