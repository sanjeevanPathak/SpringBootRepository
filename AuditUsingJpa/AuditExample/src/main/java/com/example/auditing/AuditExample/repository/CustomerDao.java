package com.example.auditing.AuditExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auditing.AuditExample.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

}
