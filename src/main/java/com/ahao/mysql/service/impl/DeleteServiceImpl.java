package com.ahao.mysql.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ahao.mysql.dao.IDeleteDao;
import com.ahao.mysql.service.IDeleteService;
import com.ahao.mysql.tool.ErrorcodeEnum;
import com.ahao.mysql.tool.ResultUtil;
import com.alibaba.fastjson.JSONObject;

@Service
public class DeleteServiceImpl implements IDeleteService {
	@Resource
	IDeleteDao iDeleteDao;
	
	@Override
	public JSONObject delete(JSONObject jsonParam) {
		String id = jsonParam.getString("userId");
		boolean delete = iDeleteDao.delete(id);
		if (false == delete) {
            return ResultUtil.jsonResultBasic(ErrorcodeEnum.SERVER_ERROR.getErrorcode(), 
                    ErrorcodeEnum.SERVER_ERROR.getDescribe(), false);
        }
        return ResultUtil.jsonResultBasic(ErrorcodeEnum.SUCCESS.getErrorcode(), 
                ErrorcodeEnum.SUCCESS.getDescribe(), true);
	}
}
