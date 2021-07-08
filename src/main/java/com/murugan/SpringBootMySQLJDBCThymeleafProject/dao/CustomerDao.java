package com.murugan.SpringBootMySQLJDBCThymeleafProject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.murugan.SpringBootMySQLJDBCThymeleafProject.model.Customer;
import com.murugan.SpringBootMySQLJDBCThymeleafProject.model.Sale;

@Transactional
@Repository
public class CustomerDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Customer> getCustomers(){
		String query = "select * from customer";
		List<Customer> custList = jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Customer.class));
		return custList;
	}
	
	public void deleteCustomer(int id) {
		String query ="delete from customer where customer_id=?";
		jdbcTemplate.update(query,id);
	}
	
	public void saveCust(Customer cust) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		insert.withTableName("customer").usingColumns("customer_name", "customer_age");
		BeanPropertySqlParameterSource parm = new BeanPropertySqlParameterSource(cust);
		insert.execute(parm);
	}
	
	public Customer getCustById(int id) {
		String query = "select * from customer where customer_id=?";
		Object[] args = {id};
		Customer cust = jdbcTemplate.queryForObject(query, args, BeanPropertyRowMapper.newInstance(Customer.class));
		return cust;
	}
	
	public void updateCust(Customer cust) {
		String query = "update customer set customer_name=:customer_name, customer_age=:customer_age where customer_id=:customer_id";
		BeanPropertySqlParameterSource parm = new BeanPropertySqlParameterSource(cust);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(query, parm);
	}
}