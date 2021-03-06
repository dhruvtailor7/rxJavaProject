package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class RepoSearchResponse {
    @JsonProperty("total_count")
    private Long totalCount;
    @JsonProperty("incomplete_results")
    private Boolean incompleteResults;
    private List<Repos> items;
}
