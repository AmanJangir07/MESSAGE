package com.avi_message.repository;

import com.avi_message.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findBySenderAndReceiver(String sender, String receiver);
}