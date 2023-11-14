package com.togbo.taskmanager.services;

import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.model.Employee;
import com.togbo.taskmanager.model.Team;
import com.togbo.taskmanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void addEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id, Employee employee){
        employeeRepository.deleteById(id);
    }

    public void deleteEmployeeById(Long id){
        employeeRepository.deleteById(id);
    }

    public void updateEmployee(Long id, Employee employee){
        Optional<Employee> foundEmployee = employeeRepository.findById(id);
        if(foundEmployee.isPresent()){
            employeeRepository.save(employee);
        }
    }

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Employee findById(Long id){
        Optional<Employee> foundEmployee = employeeRepository.findById(id);
        return foundEmployee.orElse(null);
    }

    public Employee findEmployee(Account account){
        return employeeRepository.findEmployeeByAccount(account.getId());
    }

    public void updateEmployeeTeamId(Long employeeId, Team team) {
        Optional<Employee> employee  = employeeRepository.findById(employeeId);
        if(employee.isPresent()){
            employee.get().setTeam(team);
        }
    }
}
