package com.spring.app.dao;

import static com.spring.app.dao.RoleDaoSqls.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.spring.app.dto.Role;
@Repository
public class RoleDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);
	
	
	public RoleDao(DataSource ds) {
		this.jdbc = new NamedParameterJdbcTemplate(ds);
		this.insertAction = new SimpleJdbcInsert(ds)
				.withTableName("role");			// insert 할 테이블 이름 설정 
		
	}

	public List<Role> selectAll(){
		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
	}
	
	public int insert(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);
		return insertAction.execute(params);
	}
	
	public int update(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);
		return jdbc.update(UPDATE, params);
	}
	
	public int deleteById(Integer id) {
		Map<String, ?>params = Collections.singletonMap("roleId", id);
		return jdbc.update(DELETE_BY_ROLE_ID, params);
	}
	
	public Role selectById(Integer id) {
		try {
			Map<String, ?> params = Collections.singletonMap("roleId", id);
			return jdbc.queryForObject(SELECT_BY_ROKE_ID, params, rowMapper);
			
		} catch (Exception e) {
			return null;
		}
	}

}
