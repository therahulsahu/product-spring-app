package com.demo.emailnotification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class EmailController {

    @Autowired private EmailService emailService;

    @Autowired
    private SmsService smsService;

    @PostMapping("/sendMail")
    public String sendMail(@RequestBody EmailDetails details) {
        return emailService.sendSimpleMail(details);
    }

    @PostMapping("/sendmessage")
    public ResponseEntity<Object> sendmessage(@RequestBody Smsrequest smsrequest) {
        String status=smsService.sendsms(smsrequest);
        if("sent".equals(status) || "queued".equals(status)) {
            System.out.println("message sent");
            return new ResponseEntity<>("sent successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("failed to send message",HttpStatus.NOT_FOUND);
    }
}
