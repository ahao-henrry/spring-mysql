package com.ahao.mysql.ctrl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ahao.mysql.service.IUpdateService;
import com.ahao.mysql.tool.HttpTool;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/Update/")
public class UpdateCtrl {
    @Resource
    private IUpdateService iUpdateService;
    Logger logger = Logger.getLogger(getClass());
    
    @ResponseBody
    @RequestMapping("UpdateNormal")
    public JSONObject updateNormal(HttpServletRequest request) {
        JSONObject jsonParam = HttpTool.readJSONParam(request);
        logger.info("--****UpdateNormal,param is : " + jsonParam);
        return iUpdateService.updateNormal(jsonParam);
    }
    
    @ResponseBody
    @RequestMapping("BatchUpdate")
    public JSONObject batchUpdate(HttpServletRequest request) {
    	JSONObject jsonParam = HttpTool.readJSONParam(request);
        logger.info("--****BatchUpdate,param is : " + jsonParam);
        return iUpdateService.batchUpdate(jsonParam);
	}
}
