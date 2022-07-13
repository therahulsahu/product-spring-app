package com.demo.emailnotification;

import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

@Configuration
public class Twilioinitializer {
	
	private final Twilioproperties twilioproperties;
	
	public Twilioinitializer(Twilioproperties twilioproperties)
	{
		this.twilioproperties=twilioproperties;
		Twilio.init(twilioproperties.getAccountSid(), twilioproperties.getAuthToken());
		System.out.println("twilio intialized with account: "+twilioproperties.getAccountSid());
	}

}