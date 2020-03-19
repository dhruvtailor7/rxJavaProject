
package com.example.demo.entity;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class User {

    @JsonProperty("avatar_url")
    private String avatarUrl;
    @JsonProperty("created_at")
    private String createdAt;
    private String email;
    private String followers;
    private String following;
    private String id;
    private String login;
    private String name;
    @JsonProperty("node_id")
    private String nodeId;
    @JsonProperty("public_repos")
    private String publicRepos;
    @JsonProperty("repos_url")
    private String reposUrl;
    private String type;
    @JsonProperty("updated_at")
    private String updatedAt;
    private String url;

}
