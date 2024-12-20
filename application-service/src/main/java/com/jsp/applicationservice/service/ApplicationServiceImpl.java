package com.jsp.applicationservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.applicationservice.dto.AppPropertiesDto;
import com.jsp.applicationservice.dto.AppResponseDto;
import com.jsp.applicationservice.dto.AppServiceDto;
import com.jsp.applicationservice.entity.AppProperties;
import com.jsp.applicationservice.entity.AppService;
import com.jsp.applicationservice.repository.AppPropertiesRepository;
import com.jsp.applicationservice.repository.AppServiceRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService{
	
	private  AppPropertiesRepository appPropertiesRepository;
	
	private  AppServiceRepository appServiceRepository;
	
//	private final AppProperties appProperties;
//	private final AppService appService;
	@Autowired
	public ApplicationServiceImpl(AppPropertiesRepository appProperties , AppServiceRepository appService) {
		this.appPropertiesRepository = appProperties;
		this.appServiceRepository = appService;
	}
	
	private AppResponseDto appResponseDto;
	
	public AppProperties createPropertiesDetails(AppPropertiesDto appPropertiesDto) {
		AppProperties appProperties = new AppProperties();
		appProperties.setCreatedBy(appPropertiesDto.getUserName());
		appProperties.setCreatedDate(new Date());
		appProperties.setPropertyKey(appPropertiesDto.getPropertyKey());
		appProperties.setPropertyValue(appPropertiesDto.getPropertyValue());
		appProperties.setModuleName(appPropertiesDto.getModuleName());
		appProperties.setModifiedDate(null);
		appProperties.setModifiedBy(null);
		return appProperties ;
	}
	
	public AppService createServiceDetails(AppServiceDto appServiceDto) {
		AppService appService = new AppService();
		appService.setServiceName(appServiceDto.getServiceName());
		appService.setServiceUrl(appServiceDto.getServiceUrl());
		appService.setStatus("succes");
		appService.setCreatedDate(new Date());
		appService.setModifiedDate(null);
		return appService;
	}

	@Override
	public AppResponseDto createProperties(List<AppPropertiesDto> appPropertiesDtos) {
		ArrayList<AppProperties> appProperties = new ArrayList<AppProperties>();
		
		for(AppPropertiesDto PropertiesDto : appPropertiesDtos) {
			appProperties.add(createPropertiesDetails(PropertiesDto));
		}
		try {
		   List<AppProperties> saveAll = appPropertiesRepository.saveAll(appProperties);
		   if(saveAll==null) {
			   appResponseDto = new AppResponseDto("FAILURE","500",null,null);
		   }
		   appResponseDto = new AppResponseDto("SUCCES","200",saveAll,null);
			
		} 
		catch (Exception e) {
			appResponseDto = new AppResponseDto("FAILURE","500",null,e.getLocalizedMessage());
		}
		return appResponseDto;
	}

	@Override
	public AppResponseDto getproperties() {
		
		try {
			   List<AppProperties> findAll = appPropertiesRepository.findAll();
			   if(findAll==null) {
				   appResponseDto = new AppResponseDto("FAILURE","500",null,null);
			   }
			   appResponseDto = new AppResponseDto("SUCCES","200",findAll,null);
				
			} 
			catch (Exception e) {
				appResponseDto = new AppResponseDto("FAILURE","500",null,e.getLocalizedMessage());
			}
			return appResponseDto;	}

	@Override
	public AppResponseDto getpropertiesByModuleName(String ModuleName) {
		
		try {
			   List<AppProperties> getpropertiesByModuleName = appPropertiesRepository.getpropertiesByModuleName(ModuleName);
			   if(getpropertiesByModuleName==null) {
				   appResponseDto = new AppResponseDto("FAILURE","500",null,null);
			   }
			   appResponseDto = new AppResponseDto("SUCCES","200",getpropertiesByModuleName,null);
				
			} 
			catch (Exception e) {
				appResponseDto = new AppResponseDto("FAILURE","500",null,e.getLocalizedMessage());
			}
			return appResponseDto;	}

	@Override
	public AppResponseDto getByPropertyKey(String propertyKey) {
		
		try {
			   AppProperties getByPropertyKey = appPropertiesRepository.getByPropertyKey(propertyKey);
			   if(getByPropertyKey==null) {
				   appResponseDto = new AppResponseDto("FAILURE","500",null,null);
			   }
			   appResponseDto = new AppResponseDto("SUCCES","200",getByPropertyKey,null);
				
			} 
			catch (Exception e) {
				appResponseDto = new AppResponseDto("FAILURE","500",null,e.getLocalizedMessage());
			}
			return appResponseDto;	
	}

	@Override
	public AppResponseDto registerService(AppServiceDto appServiceDto) {
		try {
			AppService save = appServiceRepository.save(createServiceDetails(appServiceDto));
			if(save==null) {
				appResponseDto = new AppResponseDto("FAILURE","500",null,null);
			}
			appResponseDto = new AppResponseDto("SUCCES","200",save,null);
		} catch (Exception e) {
			appResponseDto = new AppResponseDto("FAILURE","500",null,e.getLocalizedMessage());
		}
		return appResponseDto;
	}

	@Override
	public AppResponseDto getAppServiceBySericeName(String ServiceName) {
		
		try {
			AppService getAppServiceBySericeName = appServiceRepository.getAppServiceBySericeName(ServiceName);
			if(getAppServiceBySericeName==null) {
				appResponseDto = new AppResponseDto("FAILURE","500",null,null);
			}
			appResponseDto = new AppResponseDto("SUCCES","200",getAppServiceBySericeName,null);
		} catch (Exception e) {
			appResponseDto = new AppResponseDto("FAILURE","500",null,e.getLocalizedMessage());
		}
		return appResponseDto;	}
}
