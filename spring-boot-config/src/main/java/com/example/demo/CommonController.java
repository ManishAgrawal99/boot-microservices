package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

	@Value("${my.greeting}")
	public String greetingMessage;
	
	
	@GetMapping("/greeting")
	public String greeting() {
		return greetingMessage;
	}
}
