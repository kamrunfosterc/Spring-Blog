package com.codeup.springblog.services;

import com.codeup.springblog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailService")// initializes this service, sim to repository start up
public class EmailService {

        @Autowired
        public JavaMailSender emailSender;

        @Value("${spring.mail.from}")//handled in applications
        private String from;

        public void prepareAndSend(Post post, String subject, String body) {//Ad ad, String subject, String body
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setFrom(from);
            msg.setTo(post.getOwner().getEmail());
            msg.setSubject(subject);
            msg.setText(body);

            try{
                this.emailSender.send(msg);
            }
            catch (MailException ex) {
                // simply log it and go on...
                System.err.println(ex.getMessage());
            }
        }
}
