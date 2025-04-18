package com.fai.study.demo_rabbitmq.services;

import com.fai.study.demo_rabbitmq.entities.ForgotPasswordMessage;
import com.fai.study.demo_rabbitmq.entities.PasswordResetHistory;
import com.fai.study.demo_rabbitmq.repository.PasswordResetHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PasswordHistoryService {

    private final PasswordResetHistoryRepository repository;

    @RabbitListener(queues = "history.queue")
    public void listenSaveHistory(ForgotPasswordMessage message) {
        PasswordResetHistory history = new PasswordResetHistory();
        history.setEmail(message.getEmail());
        history.setNewPasswords(message.getNewPasswords());
        history.setResetRequestedAt(LocalDateTime.now());
        repository.save(history);
        System.out.println("PasswordHistoryService: Saved history for " + message.getEmail());
    }
}
