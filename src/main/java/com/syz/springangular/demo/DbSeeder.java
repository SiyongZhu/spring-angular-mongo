package com.syz.springangular.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//interface CommandLineRunner class means function in run(String... args)
//will run when spring boot application starts
@Component
public class DbSeeder implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		System.out.println("\n\nYou can do sth when app starts\n\n");
	}

}
