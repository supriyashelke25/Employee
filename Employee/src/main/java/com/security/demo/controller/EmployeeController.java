package com.security.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.security.demo.model.Employee;
import com.security.demo.service.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService es;
	
	@GetMapping("/")
	public String home() {
		return ("Hello World!!!");
	}
	
	@PostMapping("add")
	public void add(@RequestBody Employee emp) {
		es.add(emp);
	}
	
	@GetMapping("display")
	public List<Employee> display(){
		return es.display();
	}
	
	@PutMapping("update/{id}")
	public Employee update(@PathVariable Integer id, @RequestBody Employee emp) {
		//TODO: process PUT request
		
		return es.update(emp, id);
	}
	
	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable Integer id) {
		es.delete(id);
	}

}
