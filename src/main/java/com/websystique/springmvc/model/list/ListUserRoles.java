package com.websystique.springmvc.model.list;

import java.io.Serializable;
import java.util.List;

import com.websystique.springmvc.model.UserRoles;

public class ListUserRoles implements Serializable{

	private static final long serialVersionUID = 1L;

	List<UserRoles> listUserRoles;

	public List<UserRoles> getListUserRoles() {
		return listUserRoles;
	}

	public void setListUserRoles(List<UserRoles> listUserRoles) {
		this.listUserRoles = listUserRoles;
	}

}
