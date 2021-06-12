package com.microservices.department.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.department.entity.Department;
import com.microservices.department.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
	
	@Autowired
	private DepartmentService service;
	
	
	@GetMapping("/find/{departmentId}")
	public Optional<Department> findDepartmentById(@PathVariable("departmentId") Long departmentId) {
		log.info("Entering findDepartmentById method of DepartmentController");
		return this.service.findDepartmentById(departmentId);
	}
	
	@PostMapping("/save")
	public Department saveDepartment(@RequestBody Department department) {
		log.info("Entering saveDepartment method of DepartmentController");
		return this.service.saveDepartment(department);
	}

}
