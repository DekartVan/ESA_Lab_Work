package com.ssau.lab4.jms;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.ssau.lab4.service.MailService;
import com.ssau.lab4.models.Event;

@Component
@RequiredArgsConstructor
public class ConsumerMail {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerMail.class);
    private final MailService mailService;

    @RabbitListener(queues = {"${rabbitmq.queue.mail}"})
    public void consume(Event event){
        LOGGER.info(String.format("message received :: %s", event.getEventType()));
        mailService.resolve(event);
    }
}