package com.ssau.lab4.jms;

import com.ssau.lab4.models.EventType;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.ssau.lab4.models.BaseModel;
import com.ssau.lab4.models.Event;

import jakarta.persistence.Table;

@Component
@RequiredArgsConstructor
public class Producer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);
    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routing.key.mail}")
    private String routingKeyMail;

    @Value("${rabbitmq.routing.key.log}")
    private String routingKeyLog;

    public void sendMessage(BaseModel model, EventType eventType){
        Event event = Event.builder()
                .eventType(eventType.name())
                .tableName(model.getClass().getAnnotation(Table.class).name())
                .objectUuid(model.getUuid())
                .objectId(model.getUniqueId())
                .build();

        rabbitTemplate.convertAndSend(exchange, routingKeyMail, event);
        rabbitTemplate.convertAndSend(exchange, routingKeyLog, event);
        LOGGER.info(String.format("message sent :: %s", event.getEventType()));
    }
}
