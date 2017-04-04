package com.websystique.springmvc.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.websystique.springmvc.model.User;
import com.websystique.springmvc.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Value("${org.zooark.web.url}")
	private String urlRest;

	public User findByUsername(String username) {
		String urlSelectUsername = urlRest + "selectUser/{username}";
		
		Map<String, String> params = new HashMap<>();
		params.put("username", username);
		RestTemplate restTemplate = new RestTemplate();
		User user = restTemplate.getForObject(urlSelectUsername, User.class, params);
		
		return user;
	}

	public boolean isUserSSOUnique(Integer id, String username) {
		User user = findByUsername(username);
		return ( user == null || ((id != null) && (user.getId() == id)));
	}
	
}
