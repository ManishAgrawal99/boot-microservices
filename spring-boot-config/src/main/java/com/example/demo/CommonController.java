package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

	@Value("${my.greeting : default value}")
	public String greetingMessage;
	
	@Value("#{${dbvalues}}")
	private Map<String, String> dbvals;
	
	
	@GetMapping("/greeting")
	public String greeting() {
		return greetingMessage + dbvals;
	}
}
