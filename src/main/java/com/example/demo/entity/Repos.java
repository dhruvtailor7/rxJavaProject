
package com.example.demo.entity;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Repos {

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


}
