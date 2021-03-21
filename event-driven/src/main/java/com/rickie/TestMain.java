package com.rickie;

import com.rickie.domain.model.OrderFinishedEvent;

public class TestMain {
    public static void main(String[] args) {
        OrderFinishedEvent event = new OrderFinishedEvent();
        event.setCustomerId(123456789L);
        event.setEventData("Hello world");
        System.out.println(event);
    }
}
