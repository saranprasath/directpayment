package com.currency.exchange.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.currency.exchange.service.UserService;
import com.currency.exchange.web.dto.CurrencyRate;
@Controller
@RequestMapping("/currencyvalue")
public class CurrencyController {
	private UserService userService;

	public CurrencyController(UserService userService) {
		super();
		this.userService = userService;
	}
	@ModelAttribute("currency")
	public CurrencyRate CurrencyRateDto() {
		return new CurrencyRate();
	}
	@GetMapping
	public String showCurrencyvalue() {
		return "currencyvalue";
	}
	@PostMapping
	public String registercurrency(@ModelAttribute("currency") CurrencyRate RateDto) {
		userService.save(RateDto);
		return "redirect:/currencyvalue?success";
	}
	

}
