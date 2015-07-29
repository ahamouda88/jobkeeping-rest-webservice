package com.queue.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"com.queue.impl", "com.queue.service", "com.queue.rest"})
@EnableAutoConfiguration
public class SpringConfiguration extends SpringBootServletInitializer{

	 public static void main(String[] args) {
	        SpringApplication.run(SpringConfiguration.class, args);
	 }
	 
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringConfiguration.class);
	}
	 
}
