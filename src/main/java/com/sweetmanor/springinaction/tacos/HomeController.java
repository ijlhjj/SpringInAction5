package com.sweetmanor.springinaction.tacos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 主页
 */
@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "home";
	}

}
