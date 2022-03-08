package com.ms.email.adapters.inbound.consumers;

import com.ms.email.adapters.dtos.EmailDto;
import com.ms.email.adapters.outbound.persistence.entities.EmailEntity;
import com.ms.email.application.domain.Email;
import com.ms.email.application.ports.EmailServicePort;
import com.ms.email.application.services.EmailServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    public EmailServicePort emailServicePort;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDto emailDto) {
        var email = new Email();
        BeanUtils.copyProperties(emailDto, email);
        emailServicePort.sendEmail(email);
        System.out.println("Email sent to " + email.getEmailTo() + " with Status " + email.getSituation().name());
    }
}
