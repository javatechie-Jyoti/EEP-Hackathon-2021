package com.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserProfileDTO {
    @NotNull
    @JsonProperty(value ="id")
    String id;

    @NotNull
    @JsonProperty(value ="name")
    String name;

    @NotNull
    @JsonProperty(value ="gender")
    String gender;

    @NotNull
    @JsonProperty(value ="email")
    String email;
}
