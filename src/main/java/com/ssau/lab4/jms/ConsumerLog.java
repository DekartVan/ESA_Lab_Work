package com.ssau.lab4.jms;

import com.ssau.lab4.models.Event;
import com.ssau.lab4.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class ConsumerLog {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerLog.class);
    private final EventRepository eventRepository;

    @RabbitListener(queues = {"${rabbitmq.queue.log}"})
    public void consume(Event event){
        LOGGER.info(String.format("message received :: %s", event.getEventType()));
        eventRepository.save(event);
    }
}
