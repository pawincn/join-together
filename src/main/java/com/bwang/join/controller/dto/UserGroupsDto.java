package com.bwang.join.controller.dto;

import java.util.Set;

/**
 * Author: Brian Wang
 * Date: 4/25/14 7:38 PM
 */
public class UserGroupsDto {
    private Long userId;
    private Set<Long> groupIds;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Set<Long> getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(Set<Long> groupIds) {
        this.groupIds = groupIds;
    }
}
