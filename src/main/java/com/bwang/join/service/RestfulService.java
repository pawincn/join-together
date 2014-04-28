package com.bwang.join.service;

import com.bwang.join.controller.dto.ActivityDto;
import com.bwang.join.controller.dto.GroupDto;
import com.bwang.join.controller.dto.GroupUsersDto;
import com.bwang.join.controller.dto.UserDto;
import com.bwang.join.controller.dto.UserGroupsDto;
import com.bwang.join.dao.entity.Activity;
import com.bwang.join.dao.entity.ActivityInvitee;
import com.bwang.join.dao.entity.ActivityJoiner;
import com.bwang.join.dao.entity.ActivityLocation;
import com.bwang.join.dao.entity.ActivityRecurringSetting;
import com.bwang.join.dao.entity.ActivityRestriction;
import com.bwang.join.dao.entity.Message;
import com.bwang.join.dao.entity.MessageReceiver;
import com.bwang.join.dao.entity.User;
import com.bwang.join.dao.entity.UserGroup;
import com.bwang.join.dao.entity.UserGroupRef;
import com.bwang.join.util.ServiceException;

import java.util.List;
import java.util.Set;

/**
 * User: Brian Wang
 * Time: 2/2/14 9:56 PM
 */
public interface RestfulService {
    public void saveUser(UserDto user);
    public UserDto findUserByEmail(String email);
    public void saveGroup(GroupDto group);
    public GroupDto findGroupByName(String groupName);
    public Set<UserGroup> findGroupsByUserEmail(String email);
    public void saveUserGroupRef(UserGroupsDto ref);
    public void saveGroupUserRef(GroupUsersDto ref);

    /*public void saveActivityRecurringSetting(ActivityRecurringSetting setting);
    public void saveActivityRestriction(ActivityRestriction restriction);
    public void saveActivityLocation(ActivityLocation location);*/
    public void saveActivity(ActivityDto activity) throws ServiceException;
    public List<ActivityDto> findActivitiesByTitle(String activityName);
    public List<ActivityInvitee> findActivityInvitees(Long activityId);
    public List<ActivityJoiner> findActivityJoiners(Long activityId);

    public void sendMessage(Message message, Set<User> receivers);
}
