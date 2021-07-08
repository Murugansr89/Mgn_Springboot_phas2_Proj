package com.murugan.SpringBootMySQLJDBCThymeleafProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.murugan.SpringBootMySQLJDBCThymeleafProject.dao.CustomerDao;
import com.murugan.SpringBootMySQLJDBCThymeleafProject.dao.SalesDAO;
import com.murugan.SpringBootMySQLJDBCThymeleafProject.model.Customer;
import com.murugan.SpringBootMySQLJDBCThymeleafProject.model.Sale;

@CrossOrigin("*")
@Controller
public class SalesController {
	
	@Autowired
	SalesDAO salesDAO;
	
	@RequestMapping("/")
	public String homePage() {
		return "home";
	}
	
	@RequestMapping("/sales")
	public String getAllSales(Model model) {
		
		List<Sale> sales =  salesDAO.getSales();
		model.addAttribute("salesList", sales);
		
		System.out.println("List: "+ sales);
		
		return "index";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable(name="id")int id) {
		salesDAO.deleteSale(id);
		return "redirect:/sales";
	}
	
	@RequestMapping("/newSales")
	public String newSalesForm(Model model) {
		Sale sale = new Sale();
		model.addAttribute("sale",sale);
		return "new_form";
	}
	
	@RequestMapping(value="/saveSales", method = RequestMethod.POST)
	public String saveSales(@ModelAttribute("sale")Sale sale) {
		System.out.println("New Sales Details Entered: "+ sale);
		salesDAO.saveSale(sale);
		return "redirect:/sales";
	}
	
	@RequestMapping("/editSales/{id}")
	public ModelAndView editSaleForm(@PathVariable(name="id")int id) {
		System.out.println("Need to edit sale with ID: "+id);
		Sale sale = salesDAO.getSaleById(id);
		System.out.println("Update Sales Details: "+ sale);
		ModelAndView mav = new ModelAndView("edit_form");
		mav.addObject("sale",sale);
		return mav;
	}
	
	@RequestMapping(value="/updateSales", method =RequestMethod.POST)
	public String updateSale(@ModelAttribute("sale") Sale sale) {
		salesDAO.updateSale(sale);
		return "redirect:/sales";
	}
	
	//---------------------------------------------------------------------------------------------
	
	@Autowired
	CustomerDao custDAO;
	
	@RequestMapping("/cust")
	public String getAllCust(Model model) {
		
		List<Customer> cust =  custDAO.getCustomers();
		model.addAttribute("CustList", cust);
		
		System.out.println("Customer List: "+ cust);
		
		return "customerView";
	}
	
	@RequestMapping("/deleteCust/{id}")
	public String deleteCust(@PathVariable(name="id")int id) {
		custDAO.deleteCustomer(id);
		return "redirect:/cust";
	}
	
	@RequestMapping("/newCust")
	public String newCustomerForm(Model model) {
		Customer cust = new Customer();
		model.addAttribute("cust",cust);
		return "new_cust_form";
	}
	
	@RequestMapping(value="/saveCust", method = RequestMethod.POST)
	public String saveCust(@ModelAttribute("cust")Customer cust) {
		System.out.println("New Customer Details Entered: "+ cust);
		custDAO.saveCust(cust);
		return "redirect:/cust";
	}
	
	@RequestMapping("/editCust/{id}")
	public ModelAndView editCustForm(@PathVariable(name="id")int id) {
		System.out.println("Need to edit Customer with ID: "+id);
		Customer cust = custDAO.getCustById(id);
		System.out.println("Update Sales Details: "+ cust);
		ModelAndView mav = new ModelAndView("edit_cust_form");
		mav.addObject("cust",cust);
		return mav;
	}
	
	@RequestMapping(value="/updateCust", method =RequestMethod.POST)
	public String updateCust(@ModelAttribute("cust") Customer cust) {
		custDAO.updateCust(cust);
		return "redirect:/cust";
	}
	
}
