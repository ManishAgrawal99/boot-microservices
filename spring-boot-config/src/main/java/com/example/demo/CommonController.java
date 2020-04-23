package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class CommonController {

	@Value("${my.greeting: default value}")
	public String greetingMessage;
	
//	@Value("#{${dbvalues}}")
//	private Map<String, String> dbvals;
	
	
	@Autowired
	private DbSettings dbSettings;
	
	
	@Autowired
	private Environment env;
	
	
	@GetMapping("/greeting")
	public String greeting() {
		return greetingMessage + " " + dbSettings.getConnection() + " " + dbSettings.getHost()+":" + dbSettings.getPort();
	}
	
	@GetMapping("/env")
	public String getEnv() {
		
		return env.toString();
	}
}
