package com.jsp.integration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.jsp.integration.dto.CustomerDto;
import com.jsp.integration.service.CustomerServiceImpl;
@RestController
public class CustomerController {
	@Autowired
	 private CustomerServiceImpl customerServiceImpl;
	
	@PostMapping(value="/saveCustomer")
	public void registerCustomer(@RequestBody CustomerDto customerDto) {
		customerServiceImpl.saveCustomer(customerDto);
	}
	@PostMapping(value = "/sendRealTimeSms/{uniqueId}/{templateCode}")
	public void realTimeSms(@RequestHeader long uniqueId , @RequestHeader String templateCode) throws JsonMappingException, JsonProcessingException {
		customerServiceImpl.sendRealTimeSms(uniqueId, templateCode);
	}
}
