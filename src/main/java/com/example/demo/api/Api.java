package com.example.demo.api;

public interface Api {
    public static final String BASE_URL = "https://api.github.com";
    public static final String GET_USER_API = BASE_URL + "/users/%s";
    public static final String GET_FOLLOWERS_API = GET_USER_API + "/followers";
    public static final String GET_REPO_API = GET_USER_API + "/repos";
    public static final String GET_SEARCH_USER_API = BASE_URL + "/search/users?q=%s";

}
