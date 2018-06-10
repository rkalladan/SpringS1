package com.learn.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learn.spring.model.User;
import com.learn.spring.service.UserService;

//@RestController
public class RestServiceController1 {
	
	//@Autowired
	private UserService userService;

	 //@RequestMapping(value = "/users", method = RequestMethod.GET,headers="Accept=application/json")
	 public List<User> getUsers()
	 {
	  return userService.findAllUsers();
	 }
	 
}
