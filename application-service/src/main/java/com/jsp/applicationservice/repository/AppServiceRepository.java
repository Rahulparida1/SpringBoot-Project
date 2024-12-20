package com.jsp.applicationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jsp.applicationservice.entity.AppService;
@Repository
public interface AppServiceRepository extends JpaRepository<AppService, Integer>{
 @Query("from AppService where serviceName=:ServiceName")
	public AppService getAppServiceBySericeName(String ServiceName);
}
