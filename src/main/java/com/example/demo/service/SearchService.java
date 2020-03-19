package com.example.demo.service;

import com.example.demo.entity.RepoSearchResponse;
import com.example.demo.entity.UserSearchResponse;
import rx.Observable;

public interface SearchService {
    Observable<UserSearchResponse> searchUser(String keyword);

    Observable<RepoSearchResponse> searchRepo(String keyword);
}
