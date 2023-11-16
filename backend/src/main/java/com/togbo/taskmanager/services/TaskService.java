package com.togbo.taskmanager.services;

import com.togbo.taskmanager.enums.Priority;
import com.togbo.taskmanager.exceptions.ResourceNotFoundException;
import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.model.Employee;
import com.togbo.taskmanager.model.Project;
import com.togbo.taskmanager.model.Task;
import com.togbo.taskmanager.repository.EmployeeRepository;
import com.togbo.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public void addTask(Task task){
        taskRepository.save(task);
    }

    public void deleteTask(Task task){
        taskRepository.delete(task);
    }

    public void updateTask(UUID id, Task task){
        Optional<Task> foundTask = taskRepository.findById(id);
        if(foundTask.isPresent()){
            taskRepository.save(task);
        }
    }

    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    public Task findById(UUID id){
        Optional<Task> foundTask = taskRepository.findById(id);

        return foundTask.orElse(null);
    }

    public void deleteById(UUID id){
        taskRepository.deleteById(id);
    }

    public List<Task> findTasksByProject(Project project){
        return taskRepository.findTasksByProject(project.getId());
    }

    public List<Task> findTasksByEmployee(Employee employee){
        return taskRepository.findTasksByEmployee(employee.getId());
    }

    public Employee findEmployee(Account account){
        return employeeRepository.findEmployeeByAccount(account.getId());
    }

    public Task assignTask(Task task, Employee employee) throws Exception{
        List<Task> availableTasks = taskRepository.findTasksByProject(task.getProject().getId());

        if(task.getPriority() == Priority.CRITICAL) {
            Set<Employee> tasksEmployees = task.getEmployees();

            tasksEmployees.add(employee);
            task.setEmployees(tasksEmployees);
            taskRepository.save(task);
        }
        if(task.getPriority() == Priority.HIGH){
            for(Task t : availableTasks){
                if(t.getPriority() == Priority.CRITICAL){
                    throw new ResourceNotFoundException("There are higher priority tasks.");
                }
                else {
                    Set<Employee> employees = task.getEmployees();

                    employees.add(employee);
                    task.setEmployees(employees);
                    taskRepository.save(task);
                }
            }
        }
        if(task.getPriority() == Priority.MEDIUM){
            for(Task t : availableTasks){
                if(t.getPriority() == Priority.CRITICAL || t.getPriority() == Priority.HIGH){
                    throw new ResourceNotFoundException("There are higher priority tasks.");
                }
                else {
                    Set<Employee> employees = task.getEmployees();

                    employees.add(employee);
                    task.setEmployees(employees);
                    taskRepository.save(task);
                }
            }
        }
        if(task.getPriority() == Priority.LOW){
            for(Task t : availableTasks){
                if(t.getPriority() == Priority.CRITICAL ||
                        t.getPriority() == Priority.HIGH ||
                        t.getPriority() == Priority.MEDIUM){
                    throw new ResourceNotFoundException("There are higher priority tasks.");
                }
                else{
                    Set<Employee> employees = task.getEmployees();

                    employees.add(employee);
                    task.setEmployees(employees);
                    taskRepository.save(task);
                }
            }
        }
        return task;
    }
}
