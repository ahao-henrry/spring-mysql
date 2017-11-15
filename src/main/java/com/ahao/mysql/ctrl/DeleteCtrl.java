package com.ahao.mysql.ctrl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ahao.mysql.service.IDeleteService;
import com.ahao.mysql.tool.HttpTool;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/Delete/")
public class DeleteCtrl {
	@Resource
	IDeleteService iDeleteService;
	
	@ResponseBody
	@RequestMapping("Delete")
	public JSONObject delete(HttpServletRequest request) {
		JSONObject jsonParam = HttpTool.readJSONParam(request);
		return iDeleteService.delete(jsonParam);
	}
}
