package com.websystique.springmvc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.websystique.springmvc.model.UserRoles;
import com.websystique.springmvc.model.list.ListUserRoles;
import com.websystique.springmvc.service.UserRolesService;


@Service
public class UserRolesServiceImpl implements UserRolesService{
	
	@Value("${org.zooark.web.url}")
	private String urlRest;
	
	public UserRoles findById(int id) {
		String urlSelectRol = urlRest + "selectRol/{id}";
		
		Map<String, String> params = new HashMap<>();
		params.put("id", ""+id);
		RestTemplate restTemplate = new RestTemplate();
		UserRoles userRoles = restTemplate.getForObject(urlSelectRol, UserRoles.class, params);
		
		return userRoles;
	}

	public List<UserRoles> findAll() {
		String urlSelectRoles = urlRest + "selectAllRoles";
		
		RestTemplate restTemplate = new RestTemplate();
		ListUserRoles listUserRoles = restTemplate.getForObject(urlSelectRoles, ListUserRoles.class);
		
		return listUserRoles.getListUserRoles();
	}
}
