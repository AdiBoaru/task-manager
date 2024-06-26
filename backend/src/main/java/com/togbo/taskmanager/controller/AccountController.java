package com.togbo.taskmanager.controller;

import com.togbo.taskmanager.dto.AccountEmployeeDto;
import com.togbo.taskmanager.dto.AuthResponseDTO;
import com.togbo.taskmanager.dto.LoginDto;
import com.togbo.taskmanager.dto.mapper.EmployeeMapper;
import javax.mail.MessagingException;
import com.togbo.taskmanager.exceptions.InvalidAccountException;
import com.togbo.taskmanager.exceptions.ResourceNotFoundException;
import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.model.Employee;
import com.togbo.taskmanager.repository.AccountRepository;
import com.togbo.taskmanager.repository.EmployeeRepository;
import com.togbo.taskmanager.security.JwtGenerator;
import com.togbo.taskmanager.services.AccountService;
import com.togbo.taskmanager.services.EmailService;
import com.togbo.taskmanager.services.EmployeeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/register")
public class AccountController {
    public final AccountRepository accountRepository;
    public final EmployeeRepository employeeRepository;
    public final EmailService emailService;
    public final AccountService accountService;
    public final EmployeeService employeeService;

    public AuthenticationManager authenticationManager;
    private JwtGenerator jwtGenerator;
    public AccountController(AccountRepository accountRepository,
                             EmployeeRepository employeeRepository,
                             EmailService emailService,
                             AccountService accountService,
                             EmployeeService employeeService,
                             AuthenticationManager authenticationManager,
                             JwtGenerator jwtGenerator) {
        this.accountRepository = accountRepository;
        this.employeeRepository = employeeRepository;
        this.emailService = emailService;
        this.accountService = accountService;
        this.employeeService = employeeService;
        this.authenticationManager = authenticationManager;
        this.jwtGenerator = jwtGenerator;
    }

    @GetMapping
    public ResponseEntity<List<Account>> findAllAccounts() {
        List<Account> account = accountRepository.findAll();
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> findAccountById(@PathVariable Long id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()) {
            return new ResponseEntity<>(account.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/verify/{token}")
    public RedirectView verifyEmail(@PathVariable UUID token) {
        Account account = accountRepository.findByVerificationCode(token);
        if (account != null) {
            accountService.updateAccountEmailVerified(account);

            return new RedirectView("http://localhost:5173/login");
        } else
            return new RedirectView("http://localhost:5173/error");

    }

    //make use of a mapper
    @PostMapping("/employee")
    public void registerAccountEmployee(@RequestBody AccountEmployeeDto accountEmployeeDTO) throws InvalidAccountException, MessagingException, UnsupportedEncodingException{
        accountService.saveAccountAndEmployee(accountEmployeeDTO);
    }

    //without spring security
    @PostMapping("/login")
    public Employee loginEmployee(@RequestBody LoginDto loginDto) throws ResourceNotFoundException {
        Account account = accountRepository.findByEmail(loginDto.getEmail());
        Employee employee = null;
        if (account != null && account.isEmailVerified()) {
            if (account.getPassword().equals(loginDto.getPassword())) {
                employee = employeeRepository.findByAccount(account);
            } else
                throw new ResourceNotFoundException("bad request");
        }
        return employee;
    }

    //using spring security
    @PostMapping("/login1")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);

        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }

    @PostMapping("/account")
    public String processRegister(@RequestBody AccountEmployeeDto accountEmployeeDTO)
            throws UnsupportedEncodingException, ResourceNotFoundException {
        try {
            //emailService.register(accountEmployeeDTO, getSiteURL(httpServletRequest));
            return "register_success";
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace(); // or use a logging framework
            return "register_failure";
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account account) {
        accountService.isAccountUpdated(id, account);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    private String getSiteURL(HttpServletRequest request) {
        String url = "http://localhost:5173/login";
        String siteURL = request.getRequestURL().toString();
        //return siteURL.replace(request.getServletPath(), "");
        return url;
    }

    @DeleteMapping("/{id}")
    public void deleteAccountById(@PathVariable Long id){
        Optional<Account> account = accountRepository.findById(id);
        if(account.isPresent()){
            accountService.deleteAccountById(account.get().getId());
        }
    }
}

