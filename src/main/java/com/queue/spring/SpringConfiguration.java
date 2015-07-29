package com.queue.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"com.queue.impl", "com.queue.service", "com.queue.rest"})
@EnableAutoConfiguration
public class SpringConfiguration {

	 public static void main(String[] args) {
	        SpringApplication.run(SpringConfiguration.class, args);
	 }
	 
}
