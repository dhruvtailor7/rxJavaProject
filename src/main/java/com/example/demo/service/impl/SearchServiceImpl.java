package com.example.demo.service.impl;

import com.example.demo.api.Api;
import com.example.demo.entity.RepoSearchResponse;
import com.example.demo.entity.UserSearchResponse;
import com.example.demo.service.SearchService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.schedulers.Schedulers;

import static java.lang.String.format;

@Service
public class SearchServiceImpl implements SearchService {
    @Override
    public Observable searchUser(String keyword) {
        return Observable.create(subscriber -> {
            String URL = format(Api.GET_SEARCH_USER_API,keyword);
            try {
                UserSearchResponse userSearchResponse = new RestTemplate().getForObject(URL, UserSearchResponse.class);
                subscriber.onNext(userSearchResponse);
            }
            catch(Exception e){

                subscriber.onError(e);

            }

        }).doOnError(System.out::println).subscribeOn(Schedulers.computation());
    }

    @Override
    public Observable searchRepo(String keyword) {
        return Observable.create(subscriber -> {
           String URL = format(Api.GET_SEARCH_REPOS_API,keyword);
            System.out.println(URL);
            try {
                RepoSearchResponse repoSearchResponse = new RestTemplate().getForObject(URL, RepoSearchResponse.class);
                subscriber.onNext(repoSearchResponse);
            }
            catch(Exception e){
                subscriber.onError(e);
            }
        }).doOnError(System.out::println).subscribeOn(Schedulers.computation());
    }
}
