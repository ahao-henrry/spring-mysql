package com.ahao.mysql.service;

import com.alibaba.fastjson.JSONObject;

public interface IAddService {

    JSONObject saveNormal(JSONObject jsonParam);

    JSONObject saveNamedParameter(JSONObject jsonParam);

	JSONObject batchSave(JSONObject jsonParam);

}
