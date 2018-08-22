package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.UserService;

@Controller("/userController/")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/getNameById/{id}")
	@ResponseBody
	public String getNameById(@PathVariable Integer id) {
		String name = userService.getNameById(id);
		System.out.println(name);
		return name;
	}
}
