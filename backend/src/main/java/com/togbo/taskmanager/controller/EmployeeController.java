package com.togbo.taskmanager.controller;

import com.togbo.taskmanager.model.Employee;
import com.togbo.taskmanager.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> findAllEmployee(){
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id){
//        Optional<Employee> employee = Optional.ofNullable(employeeService.findById(id));
//
//        return employee.map(value -> new ResponseEntity<>(value, HttpStatus.FOUND))
//                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
        return employeeService.findById(id);
    }

    @GetMapping("/sort")
    public List<Employee> findAllSorted(@RequestParam String value, @RequestParam(defaultValue = "ASC") String direction){
        Sort.Direction sortedDirection = Sort.Direction.fromString(direction);
        Sort sort = Sort.by(sortedDirection, value);
        return employeeService.findAllSorted(sort);
    }
    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);

        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        employeeService.updateEmployee(id, employee);

        return new ResponseEntity<>(employee, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }


}
