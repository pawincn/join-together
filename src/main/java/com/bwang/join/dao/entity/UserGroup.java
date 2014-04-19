package com.bwang.join.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * Author: Brian Wang
 * Date: 4/7/14 12:33 AM
 */
@Entity
@Table(name = "user_groups")
public class UserGroup extends AbstractEntity {
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "group_desc")
    private String groupDesc;

    @ManyToMany(targetEntity = User.class, mappedBy = "groups")
    private Set<User> users;

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }
}
