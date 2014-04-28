package com.bwang.join.controller.dto;

import java.util.Set;

/**
 * Author: Brian Wang
 * Date: 4/25/14 7:41 PM
 */
public class GroupUsersDto {
    private Long groupId;
    private Set<Long> userIds;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Set<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(Set<Long> userIds) {
        this.userIds = userIds;
    }
}
