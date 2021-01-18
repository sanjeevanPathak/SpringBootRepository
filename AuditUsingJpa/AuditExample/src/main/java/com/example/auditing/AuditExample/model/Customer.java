package com.example.auditing.AuditExample.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Customer")
public class Customer extends ParentIdClass {

	private String firstName;
	
	private String lastName;
	
	@CreatedBy
	private String createdBy;
	
	@CreatedDate
	private String createdDate;
	
	
	@LastModifiedDate
	private String lastModifiedDate;
	
	@LastModifiedBy
	private String lastModifiedBy;
}
