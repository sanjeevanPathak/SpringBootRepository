package com.example.auditing.AuditExample.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.auditing.AuditExample.model.Customer;
import com.example.auditing.AuditExample.model.ModelDto;
import com.example.auditing.AuditExample.repository.CustomerDao;

@Service
@Transactional
public class CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	public String saveCustomer(ModelDto<Customer> inputRequest) {
		String currentUser = inputRequest.getCreatedBy();
		Customer customer = inputRequest.getCustomer();
		customer.setCreatedBy(currentUser);
		customerDao.save(customer);
		return "Customer Saved successfully";
	}
	
	public List<Customer> getAllCustomers(){
		return customerDao.findAll();
	}
	
	public Customer findById(Integer id) {
		return customerDao.findById(id).get();
	}
	
	public String updateCustomer(Integer id, ModelDto<Customer> inputRequest,String firstName) {
		Customer customer = findById(id);
		customer.setLastModifiedBy(inputRequest.getCreatedBy());
		customer.setFirstName(firstName);
		return "Customer Updated successfuly";
	}
}
