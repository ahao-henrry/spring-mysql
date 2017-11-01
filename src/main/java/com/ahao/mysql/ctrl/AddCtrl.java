package com.ahao.mysql.ctrl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ahao.mysql.service.IAddService;
import com.ahao.mysql.tool.HttpTool;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/Add")
public class AddCtrl {
    @Resource
    IAddService iAddService;

    /**
     * 使用普通添加方式添加
     * */
    @ResponseBody
    @RequestMapping("/AddNormal")
    public JSONObject saveNormal(HttpServletRequest request) {
        JSONObject jsonParam = HttpTool.readJSONParam(request);
        return iAddService.saveNormal(jsonParam);
    }
    
    /**
     * 使用命名参数添加方式添加
     * */
    @ResponseBody
    @RequestMapping("/AddNamedParameter")
    public JSONObject saveNamedParameter(HttpServletRequest request) {
        JSONObject jsonParam = HttpTool.readJSONParam(request);
        return iAddService.saveNamedParameter(jsonParam);
    }
}
