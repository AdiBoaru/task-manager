package com.togbo.taskmanager.services;

import com.togbo.taskmanager.dto.AccountEmployeeDto;
import com.togbo.taskmanager.exceptions.ResourceNotFoundException;
import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.model.Employee;
import com.togbo.taskmanager.repository.AccountRepository;
import com.togbo.taskmanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {

    private AccountRepository accountRepository;
    private PasswordEncoder passwordEncoder;
    private EmailService emailService;
    private EmployeeRepository employeeRepository;

    public AccountService(AccountRepository accountRepository, PasswordEncoder passwordEncoder, EmailService emailService, EmployeeRepository employeeRepository) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
        this.employeeRepository = employeeRepository;
    }

  /*  public void saveAccount1(AccountEmployeeDto accountEmployeeDTO, String url) throws MessagingException, UnsupportedEncodingException{
    //accountEmployeeDTO.setVerificationCode(UUID.randomUUID());
        //countEmployeeDTO.setEmailVerified(false);

        Account account = new Account();
        account.setEmail(accountEmployeeDTO.getEmail());
        account.setPassword(passwordEncoder.encode(accountEmployeeDTO.getPassword()));
        account.setCreatedDate(accountEmployeeDTO.getCreatedDate());
        account.setEmailVerified(false);
        account.setVerificationCode(UUID.randomUUID());

        Employee employee = new Employee();
        employee.setId(accountEmployeeDTO.getId());
        employee.setFirstName(accountEmployeeDTO.getFirstName());
        employee.setLastName(accountEmployeeDTO.getLastName());
        employee.setBirthDate(accountEmployeeDTO.getBirthDate());
        employee.setRole(accountEmployeeDTO.getRole());
        employee.setAccount(account);

        accountRepository.save(account);
        employeeRepository.save(employee);


      //  emailService.sendVerificationEmail(accountEmployeeDTO, url);
    }

   */
    public void saveAccount(AccountEmployeeDto accountEmployeeDTO){
        Account account = new Account();
        account.setEmail(accountEmployeeDTO.getEmail());
        account.setPassword(passwordEncoder.encode(accountEmployeeDTO.getPassword()));
        account.setCreatedDate(accountEmployeeDTO.getCreatedDate());
        account.setEmailVerified(false);
        account.setVerificationCode(UUID.randomUUID());

        Employee employee = new Employee();
        employee.setId(accountEmployeeDTO.getId());
        employee.setFirstName(accountEmployeeDTO.getFirstName());
        employee.setLastName(accountEmployeeDTO.getLastName());
        employee.setBirthDate(accountEmployeeDTO.getBirthDate());
        employee.setRole(accountEmployeeDTO.getRole());
        employee.setAccount(account);

        accountRepository.save(account);
        employeeRepository.save(employee);


    }

    public void deleteAccount(Long id, Account account) {
        Optional<Account> foundAccount = accountRepository.findById(id);
        if (foundAccount.isPresent()) {
            accountRepository.delete(account);
        }
    }

    public void updateAccount(Long id, Account account) {
        Optional<Account> foundAccount = accountRepository.findById(id);
        if (foundAccount.isPresent()) {
            accountRepository.save(account);
        }
    }

    public List<Account> findAll(){
        return accountRepository.findAll();
    }

    public Account findById(Long id){
        Optional<Account> foundAccount = accountRepository.findById(id);
        return foundAccount.orElse(null);
    }

    public void deleteAccountById(Long id){
        accountRepository.deleteById(id);
    }

    //verify if account already exists by email
    public boolean isAccountPresent(String email) throws ResourceNotFoundException{
        List<Account> accounts = accountRepository.findAll();
        for(Account a : accounts){
            if(a.getEmail().equals(email)){
                throw new ResourceNotFoundException("Account with this email " + email + " already exists");
            }
        }
        return true;
    }
}
