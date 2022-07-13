package com.demo.emailnotification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;

@Service
public class EmailService {

    private static final String SPRING_LOGO_IMAGE = "templates/images/spring.png";
    private static final String TEMPLATE_NAME = "emailtemplate";
    private static final String PNG_MIME = "image/png";
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine htmlTemplateEngine;

    @Value("${spring.mail.username}")
    private String sender;


    public String sendSimpleMail(EmailDetails details) {
        try {
            final MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
            final MimeMessageHelper email;
            email = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            email.setFrom(sender);
            email.setTo(details.getRecipient());
            email.setSubject(details.getSubject());

            final Context ctx = new Context(LocaleContextHolder.getLocale());
            ctx.setVariable("productname", details.getMsgBody());
            ctx.setVariable("springLogo", SPRING_LOGO_IMAGE);

            final String htmlContent = this.htmlTemplateEngine.process(TEMPLATE_NAME, ctx);
            email.setText(htmlContent, true);
            ClassPathResource clr = new ClassPathResource(SPRING_LOGO_IMAGE);
            email.addInline("springLogo", clr, PNG_MIME);
            javaMailSender.send(mimeMessage);
            System.out.println("email sent");
            return "mail sent";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "mail not sent";
        }
    }
}