package com.togbo.taskmanager.services;

import com.togbo.taskmanager.dto.AccountEmployeeDto;
import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.model.Employee;
import com.togbo.taskmanager.repository.AccountRepository;
import com.togbo.taskmanager.repository.EmployeeRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

@Service
public class EmailService {
    private final JavaMailSender javaMailSender;
    private static final String COMPANY_NAME = "Task Flow";

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendVerificationEmail(Account account, Employee employee) throws MessagingException, UnsupportedEncodingException {
        String toAddress = account.getEmail();
        String fromAddress = "adi.boaru@yahoo.com";
        String subject = "Please verify your registration";
        String verifyLink = "Verify your email to activate your account";
        String content = "Dear [[name]],<br>"
                + "Please click the link below to verify your registration:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">" + verifyLink + "</a></h3>"
                + "Thank you,<br>"
                + COMPANY_NAME;

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[name]]", employee.getFullName());

        String verifyToken = account.getVerificationCode().toString();
        String verifyURL = "http://localhost:8080/register/" + verifyToken;

     /*   if (isEmailVerified(verifyURL, account)) {
            account.setEmailVerified(true);
        }

      */

        content = content.replace("[[URL]]", verifyURL);

        helper.setText(content, true);

        javaMailSender.send(message);
    }

    private boolean isEmailVerified(String url, Account account) {
        String token = url.substring(28);
        return token.equals(account.getVerificationCode().toString());
    }
}

