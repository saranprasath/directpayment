package com.currency.exchange.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.currency.exchange.service.UserService;
import com.currency.exchange.web.dto.UserLogin;
@Controller

public class MainController {
	@Autowired
    private UserService userService;

	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}
	@GetMapping("/")
	public String home()
	{
		return "index";
	} 
//	@ModelAttribute("userlogin")
//	public UserLogin userLoginDto()
//	{
//		return new UserLogin();
//	}
//	@PostMapping("/login")
//	public String showLogin(@ModelAttribute("userlogin") UserLogin userlo) {
//		userService.loadByUsername(userlo.getUsername(),userlo.getPassword());
//		return "index";
//	}
	
}
