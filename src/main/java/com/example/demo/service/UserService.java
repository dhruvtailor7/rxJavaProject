package com.example.demo.service;

import com.example.demo.entity.RepoSearchResponse;
import com.example.demo.entity.Repos;
import com.example.demo.entity.User;
import com.example.demo.entity.UserSearchResponse;
import rx.Completable;
import rx.Observable;

import java.util.List;

public interface UserService {
    Observable<User> getUser(String login);

    Observable<List<User>> getFollowers(String login);

    Observable<Repos> getRepos(String login);


}
