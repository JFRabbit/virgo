package org.virgo.amy.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.virgo.amy.bean.User;

@RestController
@RequestMapping("/index")
public class IndexController {
	
	private static Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Value("${roncoo.secret}")
	private String randomValue;
	@Value("${roncoo.number}")
	private int randomNumber;
	@Value("${roncoo.desc}")
	private String domain;
	
	@RequestMapping("getRandom")
	public Map<String, Object> getRandom() {
		Map<String, Object> map = new HashMap<>();
		map.put("randomValue", randomValue);
		map.put("randomNumber", randomNumber);
		map.put("domain", domain);
		
		return map;
	}

	@RequestMapping("index")
	public String index() {
		return "hello world";
	}

	@RequestMapping("getMap")
	public Map<String, Object> getMap(@RequestParam int id, @RequestParam String name) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("name", name);
		return map;
	}

	@RequestMapping("getUser/{id}/{name}")
	public User getUser(@PathVariable int id, @PathVariable String name) {
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setDate(new Date());
		logger.info("user:{}", user);
		return user;
	}

}
