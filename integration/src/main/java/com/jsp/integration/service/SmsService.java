package com.jsp.integration.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.jsp.integration.dto.SmsDetails;
import com.jsp.integration.dto.StoreOTP;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
@Component
public class SmsService {

	private final String ACCOUNT_SID ="ACc655d42b214308304dd068013dcbba06";

  private final String AUTH_TOKEN = "7dd5a5fca5053cda5bea976f60fce2d1";

  private final String FROM_NUMBER = "+13344589218";

  public void send(SmsDetails sms) throws ParseException {
  	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    
  	
      int min = 100000;  
       int max = 999999; 
      int number=(int)(Math.random()*(max-min+1)+min);
   
  	
//  	String msg = "hii";
      
      String msg ="Your OTP - "+number+ " please verify this OTP in your Application by Ganesh ";
     
      
      Message message = Message.creator(new PhoneNumber(sms.getPhoneNo()), new PhoneNumber(FROM_NUMBER), msg)
              .create();
      StoreOTP.setOtp(number);
  }

//  public void receive(MultiValueMap<String, String> smscallback) {
// 
//  }

}



