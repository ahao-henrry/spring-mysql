package com.ahao.mysql.ctrl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ahao.mysql.service.IQueryService;
import com.ahao.mysql.tool.HttpTool;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/Query")
public class QueryCtrl {
    @Resource
    IQueryService iQueryService;

    /**
     * 使用普通查询方式查询
     * */
    @ResponseBody
    @RequestMapping("/QueryListNormal")
    public JSONObject queryListNormal(HttpServletRequest request) {
        return iQueryService.queryListNormal();
    }
    
    /**
     * 测试事务
     * */
    @ResponseBody
    @RequestMapping("/Transactional")
    public JSONObject transactional(HttpServletRequest request) {
        JSONObject jsonParam = HttpTool.readJSONParam(request);
        return iQueryService.transactional(jsonParam);
    }
}
