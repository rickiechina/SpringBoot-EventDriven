package com.rickie.domain.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.Objects;

@Component
@Slf4j
public class OrderEventReceiver {
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleOrderFinished(OrderFinishedEvent event) {
        log.info("Order finished event handler");
        if(Objects.isNull(event)) {
            return;
        }
        System.out.println(event.toString());
    }
}
