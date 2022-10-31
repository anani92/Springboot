package com.diakichi.starter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DiakichiRoutes {
	@RequestMapping("")
	public String welcome() {
		return "Welcome!";
	}
	@RequestMapping("/today")
	public String today() {
		return "today you will find luck";
	}
	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return "tomorrow, an opportunity will arrise!";
	}
	public static void main (String[] args) {
		
	}
}