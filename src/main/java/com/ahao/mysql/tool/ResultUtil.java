package com.ahao.mysql.tool;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class ResultUtil {

	public static <T> JSONObject jsonResultList(
	        Integer code, String message, List<T> list) {
		JSONObject jsonResult = new JSONObject();
		jsonResult.put("code", code);
		jsonResult.put("message", message);
		jsonResult.put("result", list);
		return jsonResult;
	}
	
	public static <T> JSONObject jsonResultList(
	        Integer code, String message, List<T> list,JSONObject pageInfo) {
		JSONObject jsonResult = new JSONObject();
		jsonResult.put("code", code);
		jsonResult.put("message", message);
		jsonResult.put("result", list);
		jsonResult.put("pageInfo", pageInfo);
		return jsonResult;
	}
	
	public static <T> JSONObject jsonResultBasic(
			Integer code, String message, T obj) {
		JSONObject jsonResult = new JSONObject();
		jsonResult.put("code", code);
		jsonResult.put("message", message);
		jsonResult.put("result", obj);
		return jsonResult;
	}
	
	
}
