package com.rickie.domain.model;

import lombok.Data;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class OrderEntity extends AbstractAggregateRoot {
    @Id
    @GeneratedValue
    private Long id;
    private String orderNo;
    private Long customerId;
    private Integer status;

    /**
     * 注册领域事件
     * @return
     */
    public OrderEntity confirmReceived(){
        //todo 业务逻辑
        // 注册领域事件
        registerEvent(new OrderFinishedEvent(this.getId(),this.customerId, "订单完成啦！"));
        return this;
    }
}
