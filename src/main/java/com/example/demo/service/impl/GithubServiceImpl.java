package com.example.demo.service.impl;

import com.example.demo.api.Api;
import com.example.demo.entity.Repository;
import com.example.demo.entity.User;
import com.example.demo.service.GithubService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;

@Service
public class GithubServiceImpl implements GithubService {



    @Override
    public Observable getUser(String login) {

        return Observable.create( subscriber -> {
            System.out.println("--->");
            try {
                User user = (new RestTemplate()).getForObject(format(Api.GET_USER_API, login), User.class);
                System.out.println(user);
                subscriber.onNext(user);
            }
            catch(Exception e){
                e.printStackTrace();
            }

        }).doOnError(System.out::println).subscribeOn(Schedulers.computation());
    }

    @Override
    public Observable getFollowers(String login) {
        return Observable.create( subscriber -> {
            List<User> followersList = new ArrayList<>();
            try {
                User[] user = new RestTemplate().getForObject(format(Api.GET_FOLLOWERS_API, login), User[].class);
                for (User user1 : user) {
                    followersList.add((new RestTemplate()).getForObject(format(Api.GET_USER_API, user1.getLogin()), User.class));
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            subscriber.onNext(followersList);

        }).doOnError(System.out::println).subscribeOn(Schedulers.computation());
    }

    @Override
    public Observable getRepos(String login) {
        return Observable.create( subscriber -> {
            List<Repository> repositories = Arrays.asList(new RestTemplate().getForObject(format(Api.GET_REPO_API, login), Repository[].class));
        }).doOnError(System.out::println).subscribeOn(Schedulers.io());
    }
}
