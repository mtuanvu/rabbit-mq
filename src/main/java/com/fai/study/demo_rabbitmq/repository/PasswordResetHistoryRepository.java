package com.fai.study.demo_rabbitmq.repository;

import com.fai.study.demo_rabbitmq.entities.PasswordResetHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordResetHistoryRepository extends JpaRepository<PasswordResetHistory, Long> {
}
