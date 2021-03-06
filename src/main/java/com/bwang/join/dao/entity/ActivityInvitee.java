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
 * Date: 4/7/14 12:28 AM
 */
@Entity
@Table(name = "activity_invitees")
public class ActivityInvitee extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "activity_id", nullable = false)
    private Activity activity;

    @OneToOne
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "invitee_id")
    private User invitee;

    @OneToOne
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "invited_group_id")
    private UserGroup invitedGroup;

    @Column(name = "invite_time")
    private Date invitedTime;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public User getInvitee() {
        return invitee;
    }

    public void setInvitee(User invitee) {
        this.invitee = invitee;
    }

    public UserGroup getInvitedGroup() {
        return invitedGroup;
    }

    public void setInvitedGroup(UserGroup invitedGroup) {
        this.invitedGroup = invitedGroup;
    }

    public Date getInvitedTime() {
        return invitedTime;
    }

    public void setInvitedTime(Date invitedTime) {
        this.invitedTime = invitedTime;
    }
}
