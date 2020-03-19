package com.example.demo.controller;

import com.example.demo.entity.Repos;
import com.example.demo.helper.DeferredSubscriber;
import com.example.demo.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;

@RestController
@RequestMapping("/github/search")
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping("/user/{keyword}")
    public DeferredResult<List<Repos>> searchUser(@PathVariable("keyword") String keyword){
        DeferredResult<List<Repos>> result = new DeferredResult<List<Repos>>();
        searchService.searchUser(keyword).subscribe(new DeferredSubscriber(result));
        return result;

    }

    @GetMapping("/repos/{keyword}")
    public DeferredResult<List<Repos>> searchRepository(@PathVariable("keyword") String keyword){
        DeferredResult<List<Repos>> result = new DeferredResult<List<Repos>>();
        searchService.searchRepo(keyword).subscribe(new DeferredSubscriber(result));
        return result;

    }

}
