package com.bwang.join.dao.entity;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Author: Brian Wang
 * Date: 4/21/14 9:43 AM
 */
@Entity
@Table(name = "user_group_xref")
public class UserGroupRef extends AbstractEntity {
    @ManyToOne
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "group_id")
    private UserGroup group;

    public UserGroupRef() {
    }

    public UserGroupRef(User user, UserGroup group) {
        this.user = user;
        this.group = group;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserGroup getGroup() {
        return group;
    }

    public void setGroup(UserGroup group) {
        this.group = group;
    }
}
