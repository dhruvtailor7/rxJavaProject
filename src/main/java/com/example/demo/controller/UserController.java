package com.example.demo.controller;

import com.example.demo.entity.Repos;
import com.example.demo.entity.User;
import com.example.demo.helper.DeferredSubscriber;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;

@RestController
@RequestMapping("/github")
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping("/{login}")
    public DeferredResult<User> getUser(@PathVariable("login") String login) {
        DeferredResult<User> result = new DeferredResult<User>();
        userService.getUser(login).subscribe(new DeferredSubscriber<>(result));
        return result;

    }
    @GetMapping("/{login}/followers")
    public DeferredResult<List<User>> getFollowers(@PathVariable("login") String login){
        DeferredResult<List<User>> result = new DeferredResult<List<User>>();
        userService.getFollowers(login).subscribe(new DeferredSubscriber<>(result));
        return result;

    }

    @GetMapping("/{login}/repos")
    public DeferredResult<List<Repos>> getRepos(@PathVariable("login") String login){
        DeferredResult<List<Repos>> result = new DeferredResult<List<Repos>>();
        userService.getRepos(login).subscribe(new DeferredSubscriber(result));
        return result;

    }



}
