package com.microservices.department.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.department.entity.Department;
import com.microservices.department.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {
	
	
	@Autowired
	private DepartmentRepository repository;

	public Department findDepartmentById(Long departmentId) {
		log.info("Entering findDepartmentById method of DepartmentService");
		return this.repository.findById(departmentId).get();		
	}

	public Department saveDepartment(Department department) {
		log.info("Entering saveDepartment method of DepartmentService");
		return this.repository.save(department);
	}
	
	
}
