package com.example.auditing.AuditExample.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ModelDto<T> {

	private String createdBy;
	private T customer;
}
