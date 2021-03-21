package com.rickie.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;

    /**
     * 使用集合类注册事件列表
     * @return
     */
    @DomainEvents
    Collection<Object> domainEvents(){
        List<Object> events= new ArrayList<Object>();
        events.add(new PersonSavedEvent(this.id, this.name, this.age));
        return events;
    }

    /**
     * 所有事件发布完成后调用，一般用来清空事件列表
     */
    @AfterDomainEventPublication
    void callbackMethod() {
        System.out.println("Clear domain events.");
        domainEvents().clear();
    }
}
