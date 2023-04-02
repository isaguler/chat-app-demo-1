package com.isaguler.chatappdemo1.repository;

import com.isaguler.chatappdemo1.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
