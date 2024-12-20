package com.jsp.applicationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.applicationservice.constant.AppMappingConstant;
import com.jsp.applicationservice.dto.AppPropertiesDto;
import com.jsp.applicationservice.dto.AppResponseDto;
import com.jsp.applicationservice.dto.AppServiceDto;
import com.jsp.applicationservice.service.ApplicationServiceImpl;

@RestController
public class ApplicationController {
	
	@Autowired
	private ApplicationServiceImpl applicationServiceImpl;
	
	
	@PostMapping(value=AppMappingConstant.SEND_APP_List)
	public AppResponseDto sendApp(@RequestBody List<AppPropertiesDto> appPropertiesDtos) {
		return applicationServiceImpl.createProperties(appPropertiesDtos);
	}
	
	@GetMapping(value=AppMappingConstant.GET_APP_List)
	public AppResponseDto getApp() {
		return applicationServiceImpl.getproperties();
	}
	
	@PostMapping(value=AppMappingConstant.GET_APP_List_By_ModuleName)
	public AppResponseDto getbymodulename(@RequestParam("ModuleName") String ModuleName) {
		return applicationServiceImpl.getpropertiesByModuleName(ModuleName);
    }
	
	@PostMapping(value = AppMappingConstant.GET_APP_By_PropertyKey)
	public AppResponseDto getByPropertyKey(@RequestParam("propertyKey") String propertyKey) {
		return applicationServiceImpl.getByPropertyKey(propertyKey);
	}
	
	@PostMapping(value = AppMappingConstant.SEND_APP_Serive)
	public AppResponseDto sendAppService(@RequestBody AppServiceDto appServiceDto) {
		return applicationServiceImpl.registerService(appServiceDto);
	}
	
	@PostMapping(value = AppMappingConstant.GET_APP_BY_ServiceName)
	public AppResponseDto getbyservicename(@RequestParam("ServiceName") String ServiceName ) {
		return applicationServiceImpl.getAppServiceBySericeName(ServiceName);
		
	}
}
