package com.websystique.springmvc.service;

import com.websystique.springmvc.model.User;


public interface UserService {
	
	User findByUsername(String username);
	
	boolean isUserSSOUnique(Integer id, String sso);

}