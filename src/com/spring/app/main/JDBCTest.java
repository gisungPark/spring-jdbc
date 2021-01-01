package com.spring.app.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.app.config.AppConfig;
import com.spring.app.dao.RoleDao;
import com.spring.app.dto.Role;

public class JDBCTest {
	
	public static void main(String[] args) {
		ApplicationContext context 
				= new AnnotationConfigApplicationContext(AppConfig.class);
		
		RoleDao roleDao = context.getBean(RoleDao.class);
		Role role = new Role();
		role.setRoleId(500);
		role.setDescription("CEO");
		
		/* insert */
//		System.out.println(role.toString());
//		int count = roleDao.insert(role);
//		System.out.println(count +"건 입력하였습니다.");
			
		/* update */
//		role.setRoleId(101);
//		role.setDescription("PROGRAMER");
//		int updateCount = roleDao.update(role);
//		System.out.println(updateCount +"건 수정하였습니다.");
		
		/* selectById */
//		role = roleDao.selectById(101);
//		System.out.println(role.toString());
		
		/* delete */
		int deleteCount = roleDao.deleteById(500);
		System.out.println(deleteCount +"건 삭제되었습니다.");
	}

}
