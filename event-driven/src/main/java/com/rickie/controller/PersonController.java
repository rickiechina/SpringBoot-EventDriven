package com.rickie.controller;

import com.rickie.domain.model.Person;
import com.rickie.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @PostMapping
    public long addPerson(@RequestBody Person person) {
        personRepository.save(person);
        return person.getId();
    }
}
