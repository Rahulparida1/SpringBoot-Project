package com.jsp.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.core.entity.Template;

public interface TemplateRepo extends JpaRepository<Template, Long>{
	
//	@Query(value="SELECT template_subject , template_content FROM template WHERE template_code=:templateCode" , nativeQuery=true )
//	public Template getByTemplateCode(String templateCode);
	@Query("from Template where templateCode=:templateCode")
	public Template getByTemplateCode(String templateCode);
}
