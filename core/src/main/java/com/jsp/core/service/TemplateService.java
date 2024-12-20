package com.jsp.core.service;

import com.jsp.core.dto.TemplateDto;
import com.jsp.core.entity.Template;

public interface TemplateService {
	public Template saveTemplate(TemplateDto templateDto);
	public Template getTemplateByTemplateCode(String templateCode);

}
