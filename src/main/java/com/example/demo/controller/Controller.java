package com.example.demo.controller;

import com.example.demo.entity.Repository;
import com.example.demo.entity.User;
import com.example.demo.helper.DeferredSubscriber;
import com.example.demo.service.GithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;

@RestController
@RequestMapping("/github/users")
public class Controller {

    @Autowired
    GithubService githubService;
    @GetMapping("/{login}")
    public DeferredResult<User> getUser(@PathVariable("login") String login) {
        DeferredResult<User> result = new DeferredResult<User>();
        githubService.getUser(login).subscribe(new DeferredSubscriber<>(result));
        return result;

    }
    @GetMapping("/{login}/followers")
    public DeferredResult<List<User>> getFollowers(@PathVariable("login") String login){
        DeferredResult<List<User>> result = new DeferredResult<List<User>>();
        githubService.getFollowers(login).subscribe(new DeferredSubscriber<>(result));
        return result;

    }

    @GetMapping("/{login}/repos")
    public DeferredResult<List<Repository>> getRepos(@PathVariable("login") String login){
        DeferredResult<List<Repository>> result = new DeferredResult<List<Repository>>();
        githubService.getRepos(login).subscribe(new DeferredSubscriber(result));
        return result;

    }

}
