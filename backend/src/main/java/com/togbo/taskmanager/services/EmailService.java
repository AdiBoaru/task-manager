package com.togbo.taskmanager.services;

import com.togbo.taskmanager.dto.AccountEmployeeDTO;
import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.model.Employee;
import com.togbo.taskmanager.repository.AccountRepository;
import com.togbo.taskmanager.repository.EmployeeRepository;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

@Service
public class EmailService {
    private AccountRepository accountRepository;
    private EmployeeRepository employeeRepository;
    private JavaMailSender javaMailSender;
    private static final String companyName = "Task Flow";

    public EmailService(AccountRepository accountRepository, EmployeeRepository employeeRepository, JavaMailSender javaMailSender) {
        this.accountRepository = accountRepository;
        this.employeeRepository = employeeRepository;
        this.javaMailSender = javaMailSender;
    }

    public void register(AccountEmployeeDTO accountEmployeeDTO, String url) throws MessagingException, UnsupportedEncodingException {

        //accountEmployeeDTO.setVerificationCode(UUID.randomUUID());
        //countEmployeeDTO.setEmailVerified(false);

        Account account = new Account();
        account.setEmail(accountEmployeeDTO.getEmail());
        account.setPassword(accountEmployeeDTO.getPassword());
        account.setCreatedDate(accountEmployeeDTO.getCreatedDate());
        account.setEmailVerified(false);
        account.setVerificationCode(UUID.randomUUID());

        Employee employee = new Employee();
        employee.setId(accountEmployeeDTO.getId());
        employee.setFirstName(accountEmployeeDTO.getFirstName());
        employee.setLastName(accountEmployeeDTO.getLastName());
        employee.setBirthDate(accountEmployeeDTO.getBirthDate());
  //      employee.setRole(accountEmployeeDTO.getRole());
        employee.setAccount(account);

        accountRepository.save(account);
        employeeRepository.save(employee);


        sendVerificationEmail(accountEmployeeDTO, url);
    }

    private void sendVerificationEmail(AccountEmployeeDTO accountEmployeeDTO, String httpServletRequest) throws MessagingException, UnsupportedEncodingException {
        String toAddress = accountEmployeeDTO.getEmail();
        String fromAddress = "adi.boaru@yahoo.com";
        String subject = "Please verify your registration";
        String content = "Dear [[name]],<br>"
                + "Please click the link below to verify your registration:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Thank you,<br>"
                + companyName;

        javax.mail.internet.MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, companyName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[name]]", accountEmployeeDTO.getFullName());
        String verifyURL = httpServletRequest + "/verify?code=" + accountEmployeeDTO.getVerificationCode();

        content = content.replace("[[URL]]", verifyURL);

        helper.setText(content, true);

        javaMailSender.send(message);
    }
}
