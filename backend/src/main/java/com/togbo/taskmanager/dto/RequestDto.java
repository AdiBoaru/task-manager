package com.togbo.taskmanager.dto;

import java.util.List;

public class RequestDto {

    private SearchRequestDto searchRequestDto;
    private List<SearchRequestDto> listSearchRequestDto;

    public SearchRequestDto getSearchRequestDto() {
        return searchRequestDto;
    }

    public void setSearchRequestDto(SearchRequestDto searchRequestDto) {
        this.searchRequestDto = searchRequestDto;
    }

    public List<SearchRequestDto> getListSearchRequestDto() {
        return listSearchRequestDto;
    }

    public void setListSearchRequestDto(List<SearchRequestDto> listSearchRequestDto) {
        this.listSearchRequestDto = listSearchRequestDto;
    }
}
