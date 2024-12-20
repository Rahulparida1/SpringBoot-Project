package com.jsp.applicationservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jsp.applicationservice.entity.AppProperties;
@Repository
public interface AppPropertiesRepository extends JpaRepository<AppProperties, Integer>{
	@Query("from AppProperties where moduleName=:moduleName")
	public List<AppProperties> getpropertiesByModuleName(String moduleName);
	
	@Query("from AppProperties where propertyKey=:propertyKey")
	public AppProperties getByPropertyKey(String propertyKey);
}
