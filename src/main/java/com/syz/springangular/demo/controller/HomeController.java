package com.syz.springangular.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping(value= {"/", "/home"})
	public String index() {
		return "Welcome to my App";
	}
}
