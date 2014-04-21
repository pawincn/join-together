package com.bwang.join.dao.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * Author: Brian Wang
 * Date: 4/21/14 5:07 PM
 */
@Entity
@Table(name = "activity_joiners")
public class ActivityJoiner extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "activity_id", nullable = false)
    private Activity activity;

    @OneToOne
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "joiner_id")
    private User joiner;

    @Column(name = "join_time")
    private Date invitedTime;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public User getJoiner() {
        return joiner;
    }

    public void setJoiner(User joiner) {
        this.joiner = joiner;
    }

    public Date getInvitedTime() {
        return invitedTime;
    }

    public void setInvitedTime(Date invitedTime) {
        this.invitedTime = invitedTime;
    }
}
