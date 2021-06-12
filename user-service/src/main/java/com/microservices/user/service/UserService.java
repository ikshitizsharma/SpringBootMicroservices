package com.microservices.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.microservices.user.entity.User;
import com.microservices.user.repository.UserRepository;
import com.microservices.user.vo.Department;
import com.microservices.user.vo.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RestTemplate template;

	public ResponseTemplateVO findUserById(@PathVariable("userId") Long userId) {
		log.info("Entering findUserById method of UserService");
		
		ResponseTemplateVO responseVO = new ResponseTemplateVO();
		
		Optional<User> user = this.repository.findById(userId);
		responseVO.setUser(user.get());
		
		Department department = template.getForObject("http://DEPARTMENT-SERVICE/departments/find/"+user.get().getDepartmentId(), Department.class);
		responseVO.setDepartment(department);
		
		return responseVO;
	}

	public User saveUser(@RequestBody User user) {
		log.info("Entering saveUser method of UserService");
		return this.repository.save(user);
		
	}
	

}
