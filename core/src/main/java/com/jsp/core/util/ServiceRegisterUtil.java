package com.jsp.core.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.jsp.core.dto.ReadRequestDto;
import com.jsp.core.service.QueryServiceImpl;

@Component
public class ServiceRegisterUtil {
	
	public static JdbcTemplate jdbcTemplate;
	public static QueryServiceImpl queryServiceImpl;
	
	@Autowired
	public ServiceRegisterUtil(JdbcTemplate jdbcTemplate , QueryServiceImpl queryServiceImpl) {
		this.jdbcTemplate = jdbcTemplate;
		this.queryServiceImpl = queryServiceImpl;
	}
	
//	public static void registerService(String serviceName , String serviceUrl) {
//		String query = "SELECT modified_date FROM application-service WHERE service_name = ?";
//		Date modifiedDate = jdbcTemplate.queryForObject(query, Date.class,serviceName);
//		
//		if(modifiedDate == null || modifiedDate != null) {
//			String updateQuery = "UPDATE application-service SET modified_date = ? WHERE service_name=?";
//			jdbcTemplate.update(updateQuery, new Date(), serviceName);
//		}
//	}
	
	public void registerService(ReadRequestDto readRequestDto , String serviceName) {
		try {
			String query = queryServiceImpl.generateSQLQuery(readRequestDto);
		  Date existingmodifiedDate = jdbcTemplate.queryForObject(query, Date.class,serviceName);
		  
		  if(existingmodifiedDate == null ||  existingmodifiedDate != null) {
			  String updateQuery = "UPDATE app_service SET modified_date = ? WHERE service_name=?";
			  jdbcTemplate.update(updateQuery , new Date(), serviceName);
		  }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
