package com.bwang.join.service.impl;

import com.bwang.join.dao.EntityDao;
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
import com.bwang.join.service.RestfulService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * User: Brian Wang
 * Time: 1/8/14 11:25 PM
 */
public class RestfulServiceImpl implements RestfulService {
    private EntityDao entityDao;

    public void setEntityDao(EntityDao entityDao) {
        this.entityDao = entityDao;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityDao.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserByEmail(String email) {
        return entityDao.findUserByEmail(email);
    }

    @Override
    @Transactional
    public void saveUserGroup(UserGroup group) {
        entityDao.save(group);
    }

    @Override
    @Transactional(readOnly = true)
    public UserGroup findUserGroupByName(String name) {
        return entityDao.findUserGroupByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<UserGroup> findUserGroupsByUserEmail(String email) {
        return entityDao.findUserGroupsByUserEmail(email);
    }

    @Override
    @Transactional
    public void saveUserGroupRef(UserGroupRef ref) {
        entityDao.save(ref);
    }

    @Override
    @Transactional
    public void saveActivityRecurringSetting(ActivityRecurringSetting setting) {
        entityDao.save(setting);
    }

    @Override
    @Transactional
    public void saveActivityRestriction(ActivityRestriction restriction) {
        entityDao.save(restriction);
    }

    @Override
    @Transactional
    public void saveActivityLocation(ActivityLocation location) {
        entityDao.save(location);
    }

    @Override
    @Transactional
    public void saveActivity(Activity activity) {
        entityDao.save(activity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Activity> findActivitiesByTitle(String activityTitle) {
        return entityDao.findActivitiesByTitle(activityTitle);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ActivityInvitee> findActivityInvitees(Long activityId) {
        return entityDao.findActivityInvitees(activityId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ActivityJoiner> findActivityJoiners(Long activityId) {
        return entityDao.findActivityJoiners(activityId);
    }

    @Override
    @Transactional
    public void sendMessage(Message message, Set<User> receivers) {
        entityDao.sendMessage(message, receivers);
    }

}
