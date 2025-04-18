package com.fai.study.demo_rabbitmq.services;

import com.fai.study.demo_rabbitmq.entities.ForgotPasswordMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ForgotPasswordService {

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;


    public void forgotPassword(String userEmail, String newPasswords) {
        ForgotPasswordMessage message = new ForgotPasswordMessage(userEmail, newPasswords);
        rabbitTemplate.convertAndSend(exchangeName, "", message);
    }
}
