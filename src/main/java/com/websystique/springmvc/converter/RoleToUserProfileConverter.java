package com.websystique.springmvc.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.websystique.springmvc.model.UserRoles;
import com.websystique.springmvc.service.UserRolesService;

/**
 * A converter class used in views to map id's to actual userProfile objects.
 */
@Component
public class RoleToUserProfileConverter implements Converter<Object, UserRoles>{
	
	@Autowired
	UserRolesService userRolesService;

	/**
	 * Gets UserProfile by Id
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	public UserRoles convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		UserRoles profile= userRolesService.findById(id);
		return profile;
	}
	
}