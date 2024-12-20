package com.jsp.integration.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.jsp.integration.dto.CustomerDto;
import com.jsp.integration.entity.Costumer;

public interface CustomerService {
	public Costumer saveCustomer(CustomerDto customerDto);
	
	public void sendRealTimeSms(long uniqueId , String templateCode) throws JsonMappingException, JsonProcessingException;


}
