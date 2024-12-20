package com.jsp.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.core.dto.TemplateDto;
import com.jsp.core.entity.Template;
import com.jsp.core.service.TemplateService;
import com.jsp.core.service.TemplateServiceImpl;

@RestController
public class TemplateController {
	@Autowired
	private TemplateServiceImpl templateServiceImpl;

	@PostMapping(value="/createTemplate")
	public ResponseEntity<Template> createTemplet(@RequestBody TemplateDto templateDto) {
		Template template = templateServiceImpl.saveTemplate(templateDto);
		return ResponseEntity.ok(template);
	}
	@GetMapping(value = "/getbyCode/{templateCode}")
	public Template getTemplatebycode(@PathVariable String templateCode) {
		return templateServiceImpl.getTemplateByTemplateCode(templateCode);
	}

}
