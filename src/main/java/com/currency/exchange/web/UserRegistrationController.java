package com.currency.exchange.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.currency.exchange.service.UserService;
import com.currency.exchange.web.dto.UserRegistration;
import org.springframework.web.bind.annotation.*	;
@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	
	private UserService userService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	@ModelAttribute("user")
	public UserRegistration userRegistrationDto() {
		return new UserRegistration();
	}
	@GetMapping
	public String showRegistration() {
		return "registration";
	}
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistration registrationDto) {
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}

}
