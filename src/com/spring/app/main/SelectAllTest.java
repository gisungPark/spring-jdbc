package com.spring.app.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.app.config.AppConfig;
import com.spring.app.dao.RoleDao;
import com.spring.app.dto.Role;

public class SelectAllTest {
	public static void main(String[] args) {
		ApplicationContext ct 
			= new AnnotationConfigApplicationContext(AppConfig.class);
		
		RoleDao roleDao = ct.getBean(RoleDao.class);
		List<Role> list = roleDao.selectAll();
	
		for(Role r: list) {
			System.out.println(r.toString());
		}
	}
}
