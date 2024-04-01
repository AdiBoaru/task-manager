package com.togbo.taskmanager.services;

import com.togbo.taskmanager.dto.AccountEmployeeDto;
import com.togbo.taskmanager.dto.mapper.AccountMapper;
import com.togbo.taskmanager.dto.mapper.EmployeeMapper;
import com.togbo.taskmanager.exceptions.InvalidAccountException;
import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.model.Employee;
import com.togbo.taskmanager.repository.AccountRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;

@Service
public class AccountService {

    private AccountRepository accountRepository;
    private EmailService emailService;
    private EmployeeService employeeService;
    private PasswordEncoder passwordEncoder;

    public AccountService(AccountRepository accountRepository, EmailService emailService, EmployeeService employeeService, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.emailService = emailService;
        this.employeeService = employeeService;
        this.passwordEncoder = passwordEncoder;
    }


    /**
     * Saves the provided account and employee details.
     * <p>
     * This method retrieves an account by email from the repository. If the account
     * does not exist, it creates a new account based on the provided DTO and maps
     * the account and employee data to corresponding entities. Finally, it adds the
     * employee to the system and persists the account and employee entities.
     *
     * @param accountEmployeeDTO
     * @throws InvalidAccountException
     */
    public void saveAccountAndEmployee(AccountEmployeeDto accountEmployeeDTO) throws InvalidAccountException, UnsupportedEncodingException, MessagingException {
        Account account = accountRepository.findByEmail(accountEmployeeDTO.getEmail());
        if (!isAccountPresent(account)) {
            account = AccountMapper.mapToAccount(accountEmployeeDTO);
            if (emailFormatValidation(account.getEmail())) {
                UUID verificationCode = generateVerificationToken();
                account.setVerificationCode(verificationCode);

                Employee employee = EmployeeMapper.mapToEmployee(accountEmployeeDTO, account);

                emailService.sendVerificationEmail(account, employee);

                employeeService.addEmployee(employee);
                accountRepository.save(account);
            } else
                throw new InvalidAccountException("Invalid email format");
        } else
            throw new InvalidAccountException("There is an account with the current email " + accountEmployeeDTO.getEmail());

    }

    private UUID generateVerificationToken() {
        return UUID.randomUUID();
    }

    /**
     * Verify if the Account is not null by given account
     *
     * @param account
     * @return @{code true} if there is an account
     * {@code false} if there isn`t an account
     */
    private boolean isAccountPresent(Account account) {
        return account != null;
    }

    public void updateAccountEmailVerified(Account account) {
        account.setEmailVerified(true);
        accountRepository.save(account);
    }

    public void isAccountUpdated(Long id, Account account) {
        Optional<Account> foundAccount = accountRepository.findById(id);
        if (foundAccount.isPresent()) {
            updateStateOfAccountOnlyIfNotNull(foundAccount.get(), account);
        }
    }

    private void updateStateOfAccountOnlyIfNotNull(Account existingAccount, Account account) {
        checkIfStateIsNull(account.getEmail(), existingAccount::setEmail);
        checkIfStateIsNull(account.getPassword(), existingAccount::setPassword);
        checkIfStateIsNull(account.getRole(), existingAccount::setRole);

        accountRepository.save(existingAccount);
    }

    private <T> void checkIfStateIsNull(T value, Consumer<T> state) {
        if (value != null) {
            state.accept(value);
        }
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account findById(Long id) {
        Optional<Account> foundAccount = accountRepository.findById(id);
        return foundAccount.orElse(null);
    }

    public void deleteAccountById(Long id) {
        accountRepository.deleteById(id);
    }

    /**
     * Validates the format of an email address.
     * <p>
     * The email address must:
     * - Start with a letter.
     * - End with either "@yahoo.com" or "@gmail.com".
     *
     * @param email The email address to be validated
     * @return {@code true} if the email address is valid @{code false} if the email addres is invalid
     */
    private boolean emailFormatValidation(String email) {
        String yahoo = "@yahoo.com";
        String gmail = "@gmail.com";
        char firstCharacter = email.charAt(0);
        if (Character.isLetter(firstCharacter)) {
            return email.endsWith(yahoo) || email.endsWith(gmail);
        }
        return false;
    }
}
