package com.example.demo.api;

public interface Api {
    public static final String GET_USER_API = "https://api.github.com/users/%s";
    public static final String GET_FOLLOWERS_API = GET_USER_API + "/followers";
    public static final String GET_REPO_API = GET_USER_API + "/repos";

}
