package com.avi_message.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sender", nullable = false)
    private String sender;

    @Column(name = "receiver", nullable = false)
    private String receiver;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    // Getter for id
    public Long getId() {
        return id;
    }

    // Setter for id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for sender
    public String getSender() {
        return sender;
    }

    // Setter for sender
    public void setSender(String sender) {
        this.sender = sender;
    }

    // Getter for receiver
    public String getReceiver() {
        return receiver;
    }

    // Setter for receiver
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    // Getter for content
    public String getContent() {
        return content;
    }

    // Setter for content
    public void setContent(String content) {
        this.content = content;
    }

    // Getter for timestamp
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // Setter for timestamp
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}