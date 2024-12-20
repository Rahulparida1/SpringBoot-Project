package com.jsp.integration.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.integration.dto.StoreOTP;
import com.jsp.integration.dto.TempOTP;

@RestController
public class VerifyOTPController {
	
	@PostMapping("/otp")
	public String verifyOTP(@RequestBody TempOTP otp) {
		
		if(otp.getOtp()==StoreOTP.getOtp()) {
		return "correct otp";
		}
		else {
			return "incorrect otp";
		}
	}

}
