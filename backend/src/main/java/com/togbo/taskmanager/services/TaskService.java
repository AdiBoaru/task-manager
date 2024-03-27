package com.togbo.taskmanager.services;

import com.togbo.taskmanager.dto.TaskDto;
import com.togbo.taskmanager.dto.mapper.TaskMapper;
import com.togbo.taskmanager.exceptions.InvalidArgumentException;
import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.model.Employee;
import com.togbo.taskmanager.model.Project;
import com.togbo.taskmanager.model.Task;
import com.togbo.taskmanager.repository.EmployeeRepository;
import com.togbo.taskmanager.repository.ProjectRepository;
import com.togbo.taskmanager.repository.TaskRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * TODO
 * **Task Categories and Tags**:
 * Allow users to categorize tasks into different categories or assign tags to tasks for better organization and filtering.
 * <p>
 * check if due date of an task should be maxim till project due date
 */
@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;

    public TaskService(TaskRepository taskRepository, EmployeeRepository employeeRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    public List<Task> findTasksByProject(Project project) {
        return taskRepository.findTasksByProject(project.getId());
    }

    public List<Task> findTasksByEmployee(Employee employee) {
        return taskRepository.findTasksByEmployee(employee.getId());
    }

    public void createTask(TaskDto taskDto) throws InvalidArgumentException {
        if (isTaskPresent(taskDto.getName())) {
            throw new InvalidArgumentException("Task with name : " + taskDto.getName() + " already exits");
        } else if (!isTaskDueDateValid(taskDto)) {
            throw new InvalidArgumentException("Task Due Date is invalid. Should be before Project due date");
        } else {
            Task task = TaskMapper.mapperToTask(taskDto);
            taskRepository.save(task);
        }
    }

    private boolean isTaskPresent(String name) {
        Optional<Task> task = taskRepository.findByName(name);
        return task.isPresent();
    }

    /**
     * Check if Task Due-Date is less or equal with Project Due-Date
     *
     * @return Long id - i
     */
    private boolean isTaskDueDateValid(TaskDto taskDto) {
        Optional<Project> project = projectRepository.findById(taskDto.getId());
        if (project.isPresent()) {
            LocalDate taskDueDate = taskDto.getDueDate();
            LocalDate projectDueDate = project.get().getDueDate();
            return taskDueDate.isBefore(projectDueDate) || taskDueDate.isEqual(projectDueDate);
        }
        return false;
    }


    public void updateTask(Long id, TaskDto taskDto) {
        Optional<Task> foundTask = findById(id);
        if (foundTask.isPresent()) {
            Task task = foundTask.get();
            checkIfStateIsNotNull(taskDto.getName(), task::setName);
            checkIfStateIsNotNull(taskDto.getDescription(), task::setDescription);
            checkIfStateIsNotNull(taskDto.getDueDate(), task::setDueDate);
            checkIfStateIsNotNull(taskDto.getStatus(), task::setStatus);
            checkIfStateIsNotNull(taskDto.getPriority(), task::setPriority);

            taskRepository.save(task);
        }
    }

    private <T> void checkIfStateIsNotNull(T task, Consumer<T> state) {
        if (task != null) {
            state.accept(task);
        }
    }

    /**
     * check first if a task is present and then delete it
     *
     * @param id
     */
    public boolean deleteById(Long id) {
        Optional<Task> task = findById(id);
        if (task.isPresent()) {
            taskRepository.deleteById(task.get().getId());
            return true;
        }
        return false;
    }

    public Employee findEmployee(Account account) {
        return employeeRepository.findEmployeeByAccount(account.getId());
    }

    public List<Task> findAllSorted(Sort sort) {
        return taskRepository.findAll(sort);
    }
}
