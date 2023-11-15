package com.togbo.taskmanager.services;

import com.togbo.taskmanager.dto.SearchRequestDto;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


@Service
public class FilterSpecificationService<T> {

    //equals
    public Specification<T> getSearchSpecification(SearchRequestDto searchRequestDto) {
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(searchRequestDto.getColumn()), searchRequestDto.getValue());
            }
        };
    }
    //and
    public Specification<T> getSearchSpecificationAnd(List<SearchRequestDto> searchRequestDtos) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            for (SearchRequestDto requestDto : searchRequestDtos) {
                Predicate equal = criteriaBuilder.equal(root.get(requestDto.getColumn()), requestDto.getValue());
                predicates.add(equal);
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    //or
    public Specification<T> getSearchSpecificationOr(List<SearchRequestDto> searchRequestDtos) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            for (SearchRequestDto requestDto : searchRequestDtos) {
                Predicate equal = criteriaBuilder.equal(root.get(requestDto.getColumn()), requestDto.getValue());
                predicates.add(equal);
            }
            return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
        };
    }

}
