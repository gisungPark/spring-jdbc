package com.spring.app.main;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.app.config.AppConfig;

public class DataSourceTest {

	public static void main(String[] args) {
		ApplicationContext ct 
			= new AnnotationConfigApplicationContext(AppConfig.class);
		
		DataSource ds = ct.getBean(DataSource.class);
		Connection conn = null; 
		try {
			conn = ds.getConnection();
			if(conn != null) System.out.println("연결성공");
			else System.out.println("연결 실패");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
