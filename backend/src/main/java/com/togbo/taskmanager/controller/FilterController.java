package com.togbo.taskmanager.controller;

import com.togbo.taskmanager.dto.RequestDto;
import com.togbo.taskmanager.dto.SearchRequestDto;
import com.togbo.taskmanager.enums.Priority;
import com.togbo.taskmanager.enums.Status;
import com.togbo.taskmanager.model.Task;
import com.togbo.taskmanager.repository.TaskRepository;
import com.togbo.taskmanager.services.FilterSpecificationService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filter")
public class FilterController {
    /**
     * TODO ->Convert the string path variable to ENUM UPPERCASE
     */
    private final TaskRepository taskRepository;
    @Autowired
    private FilterSpecificationService filterSpecificationService;

    public FilterController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/priority/{PRIORITY}")
    public List<Task> findTaskByPriority(@PathVariable(name = "PRIORITY") Priority priority) {
        return taskRepository.findTaskByPriority(priority);
    }

    @GetMapping("/status/{STATUS}")
    public List<Task> findTaskByStatus(@PathVariable(name = "STATUS") Status status) {
        return taskRepository.findTaskByStatus(status);
    }

   /* @PostMapping("/specification")
    public List<Task> findTask() {
        Specification<Task> specification = new Specification<Task>() {
            @Override
            public Predicate toPredicate(Root<Task> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("priority"), Priority.MEDIUM);
            }
        };

        List<Task> tasks = taskRepository.findAll(specification);

        return tasks;
    }


    */
    @PostMapping("/specification")
    public List<Task> findTask(@RequestBody RequestDto requestDto) {
        Specification<Task> specification = filterSpecificationService.getSearchSpecification(requestDto.getSearchRequestDto());
        return taskRepository.findAll(specification);
    }


    @PostMapping("/specification/list/and")
    public List<Task> findAndTask(@RequestBody RequestDto requestDto) {
        Specification<Task> specification = filterSpecificationService.getSearchSpecificationAnd(requestDto.getListSearchRequestDto());
        return taskRepository.findAll(specification);
    }
    @PostMapping("/specification/list/or")
    public List<Task> findOrTask(@RequestBody RequestDto requestDto) {
        Specification<Task> specification = filterSpecificationService.getSearchSpecificationOr(requestDto.getListSearchRequestDto());
        return taskRepository.findAll(specification);
    }
}
