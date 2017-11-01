package com.ahao.mysql.service;

import com.alibaba.fastjson.JSONObject;

public interface IUpdateService {

    JSONObject updateNormal(JSONObject jsonParam);

	JSONObject batchUpdate(JSONObject jsonParam);

}
