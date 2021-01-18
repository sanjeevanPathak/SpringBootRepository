package com.example.auditing.AuditExample.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@MappedSuperclass
@Data
public class ParentIdClass {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String uuid;
}
