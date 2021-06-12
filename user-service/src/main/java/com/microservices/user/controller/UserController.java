package com.microservices.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.user.entity.User;
import com.microservices.user.service.UserService;
import com.microservices.user.vo.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@RestController	
@RequestMapping("/users")
@Slf4j
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/find/{userId}")
	public ResponseTemplateVO findUserById(@PathVariable("userId") Long userId) {
		log.info("Entering findUserById method of UserController");
		return this.service.findUserById(userId);	
	}
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		log.info("Entering saveUser method of UserController");
		return this.service.saveUser(user);
	}

}
