package com.fai.study.demo_rabbitmq.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForgotPasswordMessage {
    private String email;
    private String newPasswords;
}
