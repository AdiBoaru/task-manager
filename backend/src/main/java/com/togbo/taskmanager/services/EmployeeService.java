package com.togbo.taskmanager.services;

import com.togbo.taskmanager.model.Employee;
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

    public void deleteEmployee(UUID id, Employee employee){
        employeeRepository.deleteById(id);
    }

    public void deleteEmployeeById(UUID id){
        employeeRepository.deleteById(id);
    }

    public void updateEmployee(UUID id, Employee employee){
        Optional<Employee> foundEmployee = employeeRepository.findById(id);
        if(foundEmployee.isPresent()){
            employeeRepository.save(employee);
        }
    }

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Employee findById(UUID id){
        Optional<Employee> foundEmployee = employeeRepository.findById(id);
        return foundEmployee.orElse(null);
    }
}
