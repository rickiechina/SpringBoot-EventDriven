package com.rickie.domain.model;

import lombok.Value;

@Value
public class PersonSavedEvent {
    private Long id;
    private String name;
    private Integer age;
}
