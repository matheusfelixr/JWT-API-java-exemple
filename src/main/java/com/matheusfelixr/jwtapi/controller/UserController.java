package com.matheusfelixr.jwtapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheusfelixr.jwtapi.model.domain.User;
import com.matheusfelixr.jwtapi.service.UserService;



@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/create")
	public User createCategory(@RequestBody User user){
		return userService.create(user);
	}

}
