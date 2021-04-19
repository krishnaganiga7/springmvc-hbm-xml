package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.entity.Customer;
import com.demo.service.CustomerService;



@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/list") //what is this?
	public String listCustomer(Model model)
	{
		List<Customer> customers= customerService.viewAll();
		model.addAttribute("customers", customers);
		return "listc";
		
	}
	
	@GetMapping("/showForm")
	public String addShowForm(Model model)
	{
		Customer customer= new Customer();
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer)
	{
		System.out.println(customer);
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("customerId") int cid, Model model)
	{
//		System.out.println("updateForm got id"+cid);
		Customer customer=customerService.getCustomerById(cid);
		model.addAttribute(customer);
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int cid, Model model)
	{
		customerService.deleteCustomer(cid);
		return "redirect:list";
	}
}
