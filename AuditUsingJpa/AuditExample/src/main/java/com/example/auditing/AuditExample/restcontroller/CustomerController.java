package com.example.auditing.AuditExample.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.auditing.AuditExample.model.Customer;
import com.example.auditing.AuditExample.model.ModelDto;
import com.example.auditing.AuditExample.service.CustomerService;
import com.fasterxml.jackson.annotation.JacksonInject.Value;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping(value = "/saveCustomer")
	public String saveCustomer(@RequestBody ModelDto<Customer> customer) {
		
		return customerService.saveCustomer(customer);
	}
	
	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	@PutMapping(value="updateById")
	public String updateCustomer(@RequestParam(required = true) Integer id,@RequestParam(required = true) String firstName,@RequestBody ModelDto<Customer> inputRequest) {
		return customerService.updateCustomer(id,inputRequest, firstName);
	}
	
}
