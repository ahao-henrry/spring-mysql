package com.ahao.mysql.tool;

import java.io.BufferedReader;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.alibaba.fastjson.JSONObject;

public class HttpTool {
	
	public static String readJSONString(HttpServletRequest request) {
		String method = request.getMethod();
		if (method == "GET") {
			return request.getQueryString();
		} else {
			StringBuffer json = new StringBuffer();
			String line = null;
			try {
				BufferedReader reader = request.getReader();
				while ((line = reader.readLine()) != null) {
					json.append(line);
				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			return json.toString();
		}
	}
	
	public static JSONObject readJSONParam(HttpServletRequest request) {
        String method = request.getMethod();
        if (method == "GET") {
            return JSONObject.parseObject(request.getQueryString());
        } else {
            StringBuffer json = new StringBuffer();
            String line = null;
            try {
                BufferedReader reader = request.getReader();
                while ((line = reader.readLine()) != null) {
                    json.append(line);
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            return JSONObject.parseObject(json.toString());
        }
    }
	
	public static ResponseEntity<String> GetResponseEntity(String result) {
		HttpHeaders responseHeaders = new HttpHeaders();
		MediaType mediaType = new MediaType("text", "html", Charset.forName("UTF-8"));
		responseHeaders.setContentType(mediaType);
		return new ResponseEntity<String>(result, responseHeaders, HttpStatus.OK);
	}
}
