package com.jsp.applicationservice.service;

import java.util.List;

import com.jsp.applicationservice.dto.AppPropertiesDto;
import com.jsp.applicationservice.dto.AppResponseDto;
import com.jsp.applicationservice.dto.AppServiceDto;
import com.jsp.applicationservice.entity.AppProperties;

public interface ApplicationService {
	public AppResponseDto createProperties(List<AppPropertiesDto> appPropertiesDtos);
	public AppResponseDto getproperties();
	public AppResponseDto getpropertiesByModuleName(String ModuleName);
	public AppResponseDto getByPropertyKey(String propertyKey);
	
	
	public AppResponseDto registerService(AppServiceDto appServiceDto);
	public AppResponseDto getAppServiceBySericeName(String ServiceName);

}
