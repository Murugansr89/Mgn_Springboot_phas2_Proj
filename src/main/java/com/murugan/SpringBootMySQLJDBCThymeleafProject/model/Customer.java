package com.murugan.SpringBootMySQLJDBCThymeleafProject.model;

public class Customer {
	
	private int customer_id;
	private String customer_name;
	private int customer_age;
	
	public Customer() {
		super();
	}
	public Customer(int customer_id, String customer_name, int customer_age) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.customer_age = customer_age;
	}
	
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public int getCustomer_age() {
		return customer_age;
	}
	public void setCustomer_age(int customer_age) {
		this.customer_age = customer_age;
	}
	
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_name=" + customer_name + ", customer_age="
				+ customer_age + "]";
	}
}
