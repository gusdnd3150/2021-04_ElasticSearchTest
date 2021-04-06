package com.example.demo.content.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.config.ElasticService;
import com.example.demo.content.vo.UserVo;
import com.google.gson.JsonObject;



@Controller
public class ElasticController {
	
	@Autowired
	ElasticService eService;
	
	private final String ELASTIC_INDEX = "test_index";
	private final String ELASTIC_TYPE = "test_type";
	
	@RequestMapping("/ela")
	public void sendPost() {
		JsonObject json = new JsonObject();
		String url = ELASTIC_INDEX + "/" + ELASTIC_TYPE;
		json.addProperty("city", "seoul");
		json.addProperty("temperature", 1.2);
		json.addProperty("season", "winter");
		UserVo user = new UserVo();
		
		Map<String, Object> result = eService.callElasticApi("POST", url, user, json.toString());
		System.out.println(result.get("resultCode"));
		System.out.println(result.get("resultBody"));
	}

}
