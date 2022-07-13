package com.demo.emailnotification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@Service
public class SmsService {

	private final Twilioproperties twilioproperties;
	
	@Autowired
	public SmsService(Twilioproperties twilioproperties)
	{
		this.twilioproperties=twilioproperties;
	}
	
	//send message to number
	public String sendsms(Smsrequest smsrequest)
	{
     
		Message message=Message.creator(new PhoneNumber(smsrequest.getNumber()), new PhoneNumber(twilioproperties.getFromNumber()), smsrequest.getMessage()).create();
        return message.getStatus().toString();
	}
}