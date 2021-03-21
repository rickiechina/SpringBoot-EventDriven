package com.rickie.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderFinishedEvent {
    private Long Id;
    private Long customerId;
    private String eventData;
}
