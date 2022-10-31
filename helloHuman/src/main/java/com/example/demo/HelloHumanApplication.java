package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController	
public class HelloHumanApplication {
	@RequestMapping("/")
	public String index(@RequestParam(value="q", required=false, defaultValue= "Human") String name, @RequestParam(value="l", required=false, defaultValue="!") String lastname, @RequestParam(value="t", required=false) Integer times) {
		String welcome = "";
		if (times != null) {
			for(int i=0;i<times;i++) {
				welcome += String.format("Hello %s %s", name, lastname);
			}
			return welcome;
		}
			 
			return String.format("Hello %s %s", name, lastname);
		}
		
	
	public static void main(String[] args) {
		SpringApplication.run(HelloHumanApplication.class, args);
	}

}
