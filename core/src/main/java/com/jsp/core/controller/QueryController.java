package com.jsp.core.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.core.constant.MappingConstant;
import com.jsp.core.dto.ReadRequestDto;
import com.jsp.core.service.QueryServiceImpl;
import com.jsp.core.util.RestUtil;
import com.jsp.core.util.ServiceRegisterUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class QueryController {
	
	private QueryServiceImpl queryServiceImpl;
	
	private RestUtil restUtil;
	
	private ServiceRegisterUtil serviceRegisterUtil;
	@Autowired
	 public QueryController(QueryServiceImpl queryServiceImpl, RestUtil restUtil, ServiceRegisterUtil serviceRegisterUtil) {
	        this.queryServiceImpl = queryServiceImpl;
	        this.restUtil = restUtil;
	        this.serviceRegisterUtil = serviceRegisterUtil;
	    }

	
    @PostMapping(value=MappingConstant.SAVE_QUERY)
    public ResponseEntity<String> executeQuery(@RequestBody ReadRequestDto readRequest) {
        String sqlQuery = queryServiceImpl.generateSQLQuery(readRequest);
        // Execute the SQL query and return the response
        // ...
        return ResponseEntity.ok(sqlQuery);
    }
    
    @Operation(summary = "Invoke External API", description = "Endpoint to invoke an external API.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully invoked external API"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
            
    })
    @GetMapping(value = MappingConstant.GET_QUERY)
    public ResponseEntity<Map<String, Object>> invokeApi(
    		@RequestParam String url,
    		@RequestParam HttpMethod method,
    		@RequestParam (required = false) Object RequestBody) throws Exception{
    	ResponseEntity<Map<String,Object>> invokeApi = (ResponseEntity<Map<String, Object>>) restUtil.invokeApi(url, method, RequestBody);
		return ResponseEntity.ok(invokeApi.getBody());
    }
//    @PostMapping("/getbyservicename")
//    public ResponseEntity<String> registerService(@RequestParam String serviceName ,
//    		                                      @RequestParam String serviceUrl){
//    	serviceRegisterUtil.registerService(serviceName, serviceUrl);
//    	
//    	return ResponseEntity.ok("succes");
//	}
    @PatchMapping(value= MappingConstant.REGISTER_QUERY_)
    public ResponseEntity<String> registerexecute(@RequestBody ReadRequestDto readRequestDto , @RequestHeader String serviceName){
    	serviceRegisterUtil.registerService(readRequestDto, serviceName);
		return ResponseEntity.ok("succes");
    	
    }

}
