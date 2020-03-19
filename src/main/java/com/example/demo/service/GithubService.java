package com.example.demo.service;

import com.example.demo.entity.Repository;
import com.example.demo.entity.User;
import rx.Observable;

import java.util.List;

public interface GithubService {
    Observable<User> getUser(String login);

    Observable<List<User>> getFollowers(String login);

    Observable<Repository> getRepos(String login);
}
