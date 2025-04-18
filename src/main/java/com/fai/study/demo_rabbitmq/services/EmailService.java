package com.fai.study.demo_rabbitmq.services;

import com.fai.study.demo_rabbitmq.entities.ForgotPasswordMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    @RabbitListener(queues = "email.queue")
    public void listenResetEmail(ForgotPasswordMessage message) {
        System.out.println("EmailService: Sending email to " + message.getEmail());

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(message.getEmail());
        mail.setSubject("Reset your password");
        mail.setText("Xin chào,\n\nĐây là mật khẩu mới của bạn: " + message.getNewPasswords()
                + "\n\nNếu không phải bạn yêu cầu, hãy bỏ qua email này.");

        mailSender.send(mail);
        System.out.println("Email sent to: " + message.getEmail());
    }
}
