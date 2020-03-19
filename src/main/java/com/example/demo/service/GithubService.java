package com.example.demo.service;

import com.example.demo.entity.Repos;
import com.example.demo.entity.User;
import rx.Observable;

import java.util.List;

public interface GithubService {
    Observable<User> getUser(String login);

    Observable<List<User>> getFollowers(String login);

    Observable<Repos> getRepos(String login);

    Observable searchUser(String keyword);
}
