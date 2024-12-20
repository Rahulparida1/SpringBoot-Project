package com.jsp.core.service;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsp.core.dto.PlaceHolderDto;
import com.jsp.core.dto.TemplateDto;
import com.jsp.core.entity.Template;
import com.jsp.core.repository.TemplateRepo;
@Service
public class TemplateServiceImpl implements TemplateService{
	@Autowired
	private TemplateRepo templateRepo;

	@Override
	public Template saveTemplate(TemplateDto templetDto) {
		
		Template template = new Template();
		template.setTemplateCode(templetDto.getTemplateCode());
		template.setEntityId(templetDto.getEntityId());
		template.setTemplateSubject(templetDto.getTemplateSubject());
		
		String encodeContent = encodeContent(templetDto.getTemplateContent());
		template.setTemplateContent(encodeContent);
		String placeholderJson = convertPlaceholdersToJson(templetDto.getPlaceholder());
		template.setPlaceholder(placeholderJson);
		
		template.setCreatedDate(new Date());
		template.setCreatedBy("provider");
		template.setModifiedBy(null);
		template.setModifiedDate(null);
		
		return templateRepo.save(template);
		
	}
	
	public String encodeContent(String templateContent) {
		return Base64.getEncoder().encodeToString(templateContent.getBytes());
	}
	private String convertPlaceholdersToJson(List<PlaceHolderDto> placeholders) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(placeholders);
        } catch (JsonProcessingException e) {
            // Handle JSON processing exception
            e.printStackTrace();
            return null;
            }
	}

	@Override
	public Template getTemplateByTemplateCode(String templateCode) {

		return templateRepo.getByTemplateCode(templateCode);
	}
}


//String formattedData = String.format("Hi, %s Good Morning", customerServiceImpl.getUserNameById(uniqueId));
//template.setTemplateContent(formattedData);
//
//template.setPlaceHolder(customerServiceImpl.fetchCustomerData());
