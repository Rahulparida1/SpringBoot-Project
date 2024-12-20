package com.jsp.core.service;

import com.jsp.core.dto.ReadRequestDto;

public interface QueryService {

	public String generateSQLQuery(ReadRequestDto readRequest);
}
