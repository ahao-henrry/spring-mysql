package com.ahao.mysql.service;

import com.alibaba.fastjson.JSONObject;

public interface IQueryService {

    JSONObject queryListNormal();

    JSONObject transactional(JSONObject jsonParam);

}
