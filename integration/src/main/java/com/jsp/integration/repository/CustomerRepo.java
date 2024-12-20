package com.jsp.integration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.integration.entity.Costumer;
@Repository
public interface CustomerRepo extends JpaRepository<Costumer, Long>{

}
