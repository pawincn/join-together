package com.bwang.join.dao.entity;

import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Set;

/**
 * Author: Brian Wang
 * Date: 3/29/14 4:16 PM
 */
@Entity
@Table(name = "messages")
public class Message extends AbstractEntity {
    @Column(name = "message")
    private String message;
    @Column(name = "send_time")
    private DateTime sendTime;

    @OneToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "activity_id", nullable = true)
    private Activity activity;

    @OneToMany(mappedBy = "message")
    private Set<MessageReceiver> receivers;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DateTime getSendTime() {
        return sendTime;
    }

    public void setSendTime(DateTime sendTime) {
        this.sendTime = sendTime;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Set<MessageReceiver> getReceivers() {
        return receivers;
    }

    public void setReceivers(Set<MessageReceiver> receivers) {
        this.receivers = receivers;
    }
}
