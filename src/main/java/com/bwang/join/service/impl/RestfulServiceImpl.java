package com.bwang.join.service.impl;

import com.bwang.join.controller.dto.ActivityDto;
import com.bwang.join.controller.dto.GroupDto;
import com.bwang.join.controller.dto.GroupUsersDto;
import com.bwang.join.controller.dto.UserDto;
import com.bwang.join.controller.dto.UserGroupsDto;
import com.bwang.join.dao.EntityDao;
import com.bwang.join.dao.entity.Activity;
import com.bwang.join.dao.entity.ActivityInvitee;
import com.bwang.join.dao.entity.ActivityJoiner;
import com.bwang.join.dao.entity.ActivityLocation;
import com.bwang.join.dao.entity.ActivityRecurringSetting;
import com.bwang.join.dao.entity.ActivityRestriction;
import com.bwang.join.dao.entity.GenderEnum;
import com.bwang.join.dao.entity.Message;
import com.bwang.join.dao.entity.User;
import com.bwang.join.dao.entity.UserGroup;
import com.bwang.join.dao.entity.UserGroupRef;
import com.bwang.join.service.RestfulService;
import com.bwang.join.util.ServiceException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
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
    public void saveUser(UserDto user) {
        entityDao.save(new User(user));
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto findUserByEmail(String email) {
        User user = entityDao.findUserByEmail(email);
        return user == null ? null : user.toUserDto();
    }

    @Override
    @Transactional
    public void saveGroup(GroupDto group) {
        entityDao.save(new UserGroup(group));
    }

    @Override
    @Transactional(readOnly = true)
    public GroupDto findGroupByName(String name) {
        UserGroup group = entityDao.findUserGroupByName(name);
        return group == null ? null : group.toGroupDto();
    }

    @Override
    @Transactional(readOnly = true)
    public Set<UserGroup> findGroupsByUserEmail(String email) {
        return entityDao.findUserGroupsByUserEmail(email);
    }

    @Override
    @Transactional
    public void saveUserGroupRef(UserGroupsDto dto) {
        Set<Long> groupIds = dto.getGroupIds();
        if (CollectionUtils.isEmpty(groupIds) || dto.getUserId() == null) {
            return;
        }
        for (Long groupId : groupIds) {
            saveUserGroupRef(dto.getUserId(), groupId);
        }
    }

    @Override
    @Transactional
    public void saveGroupUserRef(GroupUsersDto dto) {
        Set<Long> userIds = dto.getUserIds();
        if (CollectionUtils.isEmpty(userIds) || dto.getGroupId() == null) {
            return;
        }
        for (Long userId : userIds) {
            saveUserGroupRef(userId, dto.getGroupId());
        }
    }

    private void saveUserGroupRef(Long userId, Long groupId) {
        User user = entityDao.loadEntity(User.class, userId);
        UserGroup group = entityDao.loadEntity(UserGroup.class, groupId);
        entityDao.save(new UserGroupRef(user, group));
    }

    /*@Override
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
    }*/

    @Override
    @Transactional
    public void saveActivity(ActivityDto dto) throws ServiceException {
        validateActivity(dto);

        Activity activity = new Activity(dto);
        if (dto.getLongitude() != null && dto.getLatitude() != null) {
            ActivityLocation location = new ActivityLocation(dto);
            entityDao.save(location);
            activity.setLocation(location);
        }
        if (dto.getDistanceInKm() > 0 || dto.getParticipantMax() > 0
                || dto.getParticipantGender() != null || dto.getAgeMax() > 0
                || dto.getAgeMin() > 0 || dto.getStartAtTime() != null
                || dto.getStartInMinutes() > 0) {
            ActivityRestriction restriction = new ActivityRestriction();
            restriction.setDistance(dto.getDistanceInKm());
            restriction.setParticipantCountMax(dto.getParticipantMax());
            restriction.setParticipantGender(
                    dto.getParticipantGender() == null ? null :
                            GenderEnum.valueOf(dto.getParticipantGender()));
            restriction.setAgeMax(dto.getAgeMax());
            restriction.setAgeMin(dto.getAgeMin());
            restriction.setStartAtTime(dto.getStartAtTime());
            restriction.setStartInMinutes(dto.getStartInMinutes());

            if (dto.getStartTime() != null &&
                    (dto.getMondaySupported() || dto.getTuesdaySupported()
                            || dto.getWednesdaySupported() || dto.getThursdaySupported()
                            || dto.getFridaySupported() || dto.getSaturdaySupported()
                            || dto.getSundaySupported())) {
                ActivityRecurringSetting setting = new ActivityRecurringSetting();
                setting.setStartTime(dto.getStartTime());
                setting.setRecurringEnd(dto.getRecurringEnd());
                setting.setMondaySupported(dto.getMondaySupported());
                setting.setTuesdaySupported(dto.getTuesdaySupported());
                setting.setWednesdaySupported(dto.getWednesdaySupported());
                setting.setThursdaySupported(dto.getThursdaySupported());
                setting.setFridaySupported(dto.getFridaySupported());
                setting.setSaturdaySupported(dto.getSaturdaySupported());
                setting.setSundaySupported(dto.getSundaySupported());
                entityDao.save(setting);
                restriction.setRecurringSetting(setting);
            }
            entityDao.save(restriction);
            activity.setRestriction(restriction);
        }
        // todo add tags, organizer and joiner, invitee for activity
        entityDao.save(activity);
    }

    private void validateActivity(ActivityDto activity) throws ServiceException {
        if (StringUtils.isEmpty(activity.getTitle())) {
            throw new ServiceException();
        }
        if (activity.getAgeMin() < 0 || activity.getAgeMax() < 0
                || (activity.getAgeMax() < activity.getAgeMin())) {
            throw new ServiceException();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<ActivityDto> findActivitiesByTitle(String activityTitle) {
        List<Activity> entities = entityDao.findActivitiesByTitle(activityTitle);
        if (CollectionUtils.isEmpty(entities)) {
            return null;
        }
        List<ActivityDto> dtos = new ArrayList<ActivityDto>();
        for (Activity activity : entities) {
            dtos.add(activity.toActivityDto());
        }
        return dtos;
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
