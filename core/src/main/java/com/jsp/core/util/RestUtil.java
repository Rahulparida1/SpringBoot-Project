package com.jsp.core.util;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.jsp.applicationservice.constant.ApplicationConstant;

@Component
public class RestUtil {

    private final RestTemplate restTemplate;
//    private final Environment environment;
    private final Logger log = LoggerFactory.getLogger(RestUtil.class);
 

    @Autowired
    public RestUtil(RestTemplate restTemplate, Environment environment) {
        this.restTemplate = restTemplate;
//        this.environment = environment;
    }

    @SuppressWarnings("unchecked")
	public Map<String ,Object> invokeApi(String url, HttpMethod method, Object requestBody) throws Exception {
//    	url= System.getenv("APP_SERVICE_BASE_URL") + ApplicationConstant.GET_SERVICE_BY_SERVICENAME;
        try {
   
        	HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.ACCEPT, "application/json");
            
            HttpEntity<Object> requestEntity = new HttpEntity<>(requestBody,headers);
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, method.GET, requestEntity, String.class);

            String responseBody = responseEntity.getBody();

            log.info("API response: {}", responseBody);

            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> resBody = objectMapper.readValue(responseBody, Map.class);

            return resBody;
        } catch (Exception e) {
            
            log.error("Error invoking API: {}", e.getMessage());
            throw e; 
            }
		
		}
}

