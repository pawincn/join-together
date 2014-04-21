package com.bwang.join.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Author: Brian Wang
 * Date: 4/2/14 11:19 PM
 */
@Entity
@Table(name = "message_receivers")
public class MessageReceiver extends AbstractEntity {
    @OneToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    @ManyToOne
    @JoinColumn(name = "message_id")
    private Message message;

    @Column(name = "is_read")
    private boolean isRead;

    public MessageReceiver() {}

    public MessageReceiver(Message msg, User receiver) {
        this(msg, receiver, false);
    }

    public MessageReceiver(Message msg, User receiver, boolean isRead) {
        this.message = msg;
        this.receiver = receiver;
        this.isRead = isRead;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean isRead) {
        this.isRead = isRead;
    }
}
