package com.bh.beauty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bh.beauty.dao.EmployeeDao;
import com.bh.beauty.entity.Employee;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;
	
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeDao.save(employee);
	}
	
	@GetMapping("/findAll")
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}
}
