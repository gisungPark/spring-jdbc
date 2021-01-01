package com.spring.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"com.spring.app.dao"})
@Import({DBConfig.class})
public class AppConfig {
	
}
