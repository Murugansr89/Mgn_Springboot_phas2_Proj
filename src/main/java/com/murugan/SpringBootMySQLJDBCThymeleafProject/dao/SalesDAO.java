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

import com.murugan.SpringBootMySQLJDBCThymeleafProject.model.Sale;

@Transactional
@Repository
public class SalesDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Sale> getSales(){
		String query = "select * from sales";
		List<Sale> sales = jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Sale.class));
		return sales;
	}
	
	public void deleteSale(int id) {
		String query ="delete from sales where id=?";
		jdbcTemplate.update(query,id);
	}
	
	public void saveSale(Sale sale) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		insert.withTableName("sales").usingColumns("item", "quantity", "amount");
		BeanPropertySqlParameterSource parm = new BeanPropertySqlParameterSource(sale);
		insert.execute(parm);
	}
	
	public Sale getSaleById(int id) {
		String query = "select * from sales where id=?";
		Object[] args = {id};
		Sale sale = jdbcTemplate.queryForObject(query, args, BeanPropertyRowMapper.newInstance(Sale.class));
		return sale;
	}
	
	public void updateSale(Sale sale) {
		String query = "update sales set item=:item, quantity=:quantity, amount=:amount where id=:id";
		BeanPropertySqlParameterSource parm = new BeanPropertySqlParameterSource(sale);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(query, parm);
	}
}
