package com.rickie.domain.model;

import com.rickie.repository.PersonRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class PersonEventListener {
    private PersonRepository personRepository;

    public PersonEventListener(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Async
    @TransactionalEventListener
    public void handlePersonSavedEvent(PersonSavedEvent personSavedEvent) {
        System.out.println(personSavedEvent);
    }
}
