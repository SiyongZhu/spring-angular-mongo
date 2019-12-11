package com.syz.springangular.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syz.springangular.demo.models.HelloBean;

@RestController
public class HomeController {

	@GetMapping(value= {"/", "/home"})
	public String index() {
		return "Welcome to my App";
	}
	
	//return a Bean object, the Bean class must have a get method(such as getMessage())
	@GetMapping(value= {"/hello-bean"})
	public HelloBean helloBean() {
		return new HelloBean("Hello World");
	}
}
