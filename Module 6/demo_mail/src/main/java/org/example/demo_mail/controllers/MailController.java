package org.example.demo_mail.controllers;

import org.example.demo_mail.models.Mail;
import org.example.demo_mail.services.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class MailController {
@Autowired
private IMailService mailService;


    @GetMapping("/mail")
    public ResponseEntity<?> sendMail(){
        Mail mail = new Mail();
        mail.setMailFrom("duyhoangc0923g1@gmail.com");
        mail.setMailTo("nguyentukhanh2001@gmail.com");
        mail.setMailSubject("Khanhx1 ne");
        mail.setMailContent("CLMM");

        mailService.sendEmail(mail);
        return ResponseEntity.ok("da gui mail");
    }

}
