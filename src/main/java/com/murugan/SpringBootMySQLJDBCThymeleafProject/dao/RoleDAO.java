package com.murugan.SpringBootMySQLJDBCThymeleafProject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class RoleDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void getUserByName(String username) {
		String query = "SELECT ";
	}

}
