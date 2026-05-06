package com.avi_message.repository;

import com.avi_message.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUsername(String username);
}