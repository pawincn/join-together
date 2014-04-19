package com.bwang.join.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
    @OneToOne(targetEntity = User.class)
    private User receiver;
    @ManyToOne(targetEntity = Message.class)
    private Message message;
    @Column(name = "is_read")
    private boolean isRead;

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
