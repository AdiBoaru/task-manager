package com.togbo.taskmanager.security;

import com.togbo.taskmanager.enums.Role;
import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.model.Employee;
import com.togbo.taskmanager.repository.AccountRepository;
import com.togbo.taskmanager.repository.EmployeeRepository;
import com.togbo.taskmanager.services.EmployeeService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private EmployeeRepository employeeRepository;
    private AccountRepository accountRepository;

    public CustomUserDetailService(EmployeeRepository employeeRepository, AccountRepository accountRepository) {
        this.employeeRepository = employeeRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            Account account = accountRepository.findByEmail(email);
            Employee employee = employeeRepository.findByAccount(account);
            return new User(account.getEmail(), account.getPassword(), grantedAuthorities(account.getRole()));
        }catch (UsernameNotFoundException e){
            throw new UsernameNotFoundException("Account with email = "+ email +" not found.");
        }
    }

    public Collection<GrantedAuthority> grantedAuthorities(Role role){
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new SimpleGrantedAuthority(role.toString()));
        return collection;
    }
}
