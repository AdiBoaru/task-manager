package com.togbo.taskmanager.dto;

import com.togbo.taskmanager.enums.SearchOperator;

import java.util.List;

public class RequestDto {

    private SearchRequestDto searchRequestDto;
    private List<SearchRequestDto> listSearchRequestDto;

    private SearchOperator searchOperator;

    public SearchRequestDto getSearchRequestDto() {
        return searchRequestDto;
    }


    public List<SearchRequestDto> getListSearchRequestDto() {
        return listSearchRequestDto;
    }

    public SearchOperator getSearchOperator() {
        return searchOperator;
    }

}
