/*
 * author Damianos and Eftychia
 * */
package com.code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {
	
	@GetMapping("/show-menu")
	public String showMenu(Model theModel) {
	/*
	 * return menu page
	 * */
		return "menu";
	}
	@GetMapping("/login")
	String login() {
		return "login";
	}
}
