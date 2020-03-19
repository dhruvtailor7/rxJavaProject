
package com.example.demo.entity;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Repository {

    @JsonProperty("clone_url")
    private String cloneUrl;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("full_name")
    private String fullName;
    
    private Long id;
    private User owner;
    private String name;
    

    @JsonProperty("pushed_at")
    private String pushedAt;
    @JsonProperty("ssh_url")
    private String sshUrl;
    @JsonProperty("updated_at")
    private String updatedAt;

    public String getCloneUrl() {
        return cloneUrl;
    }

    public void setCloneUrl(String cloneUrl) {
        this.cloneUrl = cloneUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getPushedAt() {
        return pushedAt;
    }

    public void setPushedAt(String pushedAt) {
        this.pushedAt = pushedAt;
    }

    public String getSshUrl() {
        return sshUrl;
    }

    public void setSshUrl(String sshUrl) {
        this.sshUrl = sshUrl;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
