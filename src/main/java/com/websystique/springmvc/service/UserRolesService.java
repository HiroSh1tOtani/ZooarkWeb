package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.UserRoles;


public interface UserRolesService {

	UserRoles findById(int id);
	
	List<UserRoles> findAll();
	
}
