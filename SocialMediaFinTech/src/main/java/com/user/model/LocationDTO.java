package com.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LocationDTO {
    @NotNull
    @JsonProperty(value ="id")
    String id;

    @NotNull
    @JsonProperty(value ="name")
    String name;
}
