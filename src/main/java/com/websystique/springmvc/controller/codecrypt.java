package com.websystique.springmvc.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class codecrypt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode("123456");
		System.out.println(hashedPassword);
	}

}
