package com.ssau.lab4.service;

import com.ssau.lab4.repository.MailConditionRepository;
import lombok.RequiredArgsConstructor;
import com.ssau.lab4.models.Event;
import com.ssau.lab4.models.MailCondition;
import com.ssau.lab4.jms.ConsumerMail;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender mailSender;
    private final MailConditionRepository mailConditionRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerMail.class);

    public void sendMail(String address, Event event) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(address);
        simpleMailMessage.setSubject(
                String.format("Change in %s", event.getTableName()));
        simpleMailMessage.setText(
                String.format(
                        "Change in %s of type %s. %s %s",
                        event.getTableName(),
                        event.getEventType(),
                        event.getUuid(),
                        event.getUniqueId()));
        mailSender.send(simpleMailMessage);
    }

    public void resolve(Event Event) {
        List<MailCondition> mails = mailConditionRepository.findAllByIsDeletedFalse();
        mails.forEach(mail -> {
            try {
                JSONObject condition = new JSONObject(mail.getCondition());
                if (condition.opt(Event.getEventType()) == null)
                    return;
                var conditionList = ((JSONArray)condition.opt(Event.getEventType())).toList();
                if (conditionList.contains(Event.getTableName()) || conditionList.contains("any"))
                    sendMail(mail.getAddress(), Event);
            }
            catch (Exception e){
                LOGGER.info(e.getMessage(), e);
            }
        });
    }
}