package com.bwang.join.service;

import com.bwang.join.dao.entity.Activity;
import com.bwang.join.dao.entity.ActivityLocation;
import com.bwang.join.dao.entity.ActivityRecurringSetting;
import com.bwang.join.dao.entity.ActivityRestriction;
import com.bwang.join.dao.entity.User;
import com.bwang.join.dao.entity.UserGroup;

import java.util.List;

/**
 * User: Brian Wang
 * Time: 2/2/14 9:56 PM
 */
public interface RestfulService {
    public void saveUser(User user);
    public User findUserByEmail(String email);
    public void saveUserGroup(UserGroup group);
    public UserGroup findUserGroupByName(String groupName);

    public void saveActivityRecurringSetting(ActivityRecurringSetting setting);
    public void saveActivityRestriction(ActivityRestriction restriction);
    public void saveActivityLocation(ActivityLocation location);
    public void saveActivity(Activity activity);
    public Activity findActivityByName(String activityName);

    public List<User> listParticipants();

    public void sendMessage();
}
