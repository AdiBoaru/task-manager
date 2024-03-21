package com.togbo.taskmanager.services;

import com.togbo.taskmanager.dto.AccountEmployeeDto;
import com.togbo.taskmanager.dto.mapper.AccountMapper;
import com.togbo.taskmanager.dto.mapper.EmployeeMapper;
import com.togbo.taskmanager.exceptions.InvalidAccountException;
import com.togbo.taskmanager.exceptions.ResourceNotFoundException;
import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.model.Employee;
import com.togbo.taskmanager.repository.AccountRepository;
import com.togbo.taskmanager.repository.EmployeeRepository;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {

    private AccountRepository accountRepository;
 //   private PasswordEncoder passwordEncoder;
    private EmailService emailService;
    private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;
    public AccountService(AccountRepository accountRepository, EmailService emailService, EmployeeRepository employeeRepository, EmployeeService employeeService) {
        this.accountRepository = accountRepository;
        this.emailService = emailService;
        this.employeeRepository = employeeRepository;
        this.employeeService = employeeService;
    }

    /**
     * Saves the provided account and employee details.
     *
     * This method retrieves an account by email from the repository. If the account
     * does not exist, it creates a new account based on the provided DTO and maps
     * the account and employee data to corresponding entities. Finally, it adds the
     * employee to the system and persists the account and employee entities.
     *
     * @param accountEmployeeDTO
     * @throws InvalidAccountException
     */
    public void saveAccountAndEmployee(AccountEmployeeDto accountEmployeeDTO) throws InvalidAccountException, MessagingException, UnsupportedEncodingException {
        Account account = accountRepository.findByEmail(accountEmployeeDTO.getEmail());
        if(!isAccountPresent(account)){
            account = AccountMapper.mapToAccount(accountEmployeeDTO);
            UUID verificationCode = generateVerificationToken();
            account.setVerificationCode(verificationCode);

            Employee employee = EmployeeMapper.mapToEmployee(accountEmployeeDTO, account);

            emailService.sendVerificationEmail(account,employee);

            employeeService.addEmployee(employee);
            accountRepository.save(account);

        }else
            throw new InvalidAccountException("There is an account with the current email " + accountEmployeeDTO.getEmail());

    }

    private UUID generateVerificationToken(){
        return UUID.randomUUID();
    }
    private boolean isAccountPresent(Account account){
        return account != null;
    }

    public void deleteAccount(Long id, Account account) {
        Optional<Account> foundAccount = accountRepository.findById(id);
        if (foundAccount.isPresent()) {
            accountRepository.delete(account);
        }
    }

    public void updateAccountEmailVerified(Account account){
        account.setEmailVerified(true);
        accountRepository.save(account);
    }

    /*TODO
    de terminat si optimizat metoda updateStateOfAccountOnlyIfNotNull
     */
    public void updateAccount(Long id, Account account) {
        Optional<Account> foundAccount = accountRepository.findById(id);
        if (foundAccount.isPresent()) {
            updateStateOfAccountOnlyIfNotNull(foundAccount.get(), account);
        }
    }
    private void updateStateOfAccountOnlyIfNotNull(Account existingAccount, Account account){
        if(account.getEmail() != null){
            existingAccount.setEmail(account.getEmail());
        }
        if(account.getPassword() != null){
            existingAccount.setPassword(account.getPassword());
        }
        if(account.getRole() != null){
            existingAccount.setRole(account.getRole());
        }

        accountRepository.save(existingAccount);

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
