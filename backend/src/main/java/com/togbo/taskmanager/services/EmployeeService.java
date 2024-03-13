package com.togbo.taskmanager.services;

import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.model.Employee;
import com.togbo.taskmanager.model.Team;
import com.togbo.taskmanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    public void addEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void deleteEmployeeById(Long id){
        employeeRepository.deleteById(id);
    }

    public void updateEmployee(Long id, Employee employee){
        Optional<Employee> foundEmployee = employeeRepository.findById(id);
        foundEmployee.ifPresent(value -> updateEmployeeFields(value, employee));
    }
    private void updateEmployeeFields(Employee foundEmployee, Employee state){
        checkForNullState(state.getFirstName(), foundEmployee::setFirstName);
        checkForNullState(state.getLastName(), foundEmployee::setLastName);
        checkForNullState(state.getBirthDate(), foundEmployee::setBirthDate);
        checkForNullState(state.getAccount(), foundEmployee::setAccount);
        checkForNullState(state.getProjects(), foundEmployee::setProjects);
        checkForNullState(state.getTasks(), foundEmployee::setTasks);
    }
    private <T> void checkForNullState(T value, Consumer<T> state){
        if (value != null){
            state.accept(value);
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
        //employee.ifPresent(employee.get().setTeam(team));
        if(employee.isPresent()){
            employee.get().setTeam(team);
        }
    }

    public List<Employee> findAllSorted(Sort sort){
        return employeeRepository.findAll(sort);
    }
}
