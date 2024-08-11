package com.jiaul.virtualtutor.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    public boolean sendEmail(String toEmail, String subject, String body){
        if(toEmail.isEmpty() || body.isEmpty()) return false;
        try{
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(toEmail);
//            helper.setFrom("studysupport@demomailtrap.com");
            helper.setFrom("studysupport@gmail.com");
            helper.setSubject(subject);
            helper.setText(body, true);  // true indicates the content is HTML
            javaMailSender.send(message);
        }catch (MessagingException e){
            System.out.println("error message: "+e.getMessage());
            return false;
        }
        return true;
    }
}
