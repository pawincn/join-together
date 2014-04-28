package com.bwang.join.service;

import com.bwang.join.controller.dto.ActivityDto;
import com.bwang.join.controller.dto.GroupDto;
import com.bwang.join.controller.dto.UserDto;
import com.bwang.join.controller.dto.UserGroupsDto;
import com.bwang.join.dao.entity.ActivityInvitee;
import com.bwang.join.dao.entity.ActivityJoiner;
import com.bwang.join.dao.entity.ActivityLocation;
import com.bwang.join.dao.entity.ActivityRecurringSetting;
import com.bwang.join.dao.entity.ActivityRestriction;
import com.bwang.join.dao.entity.GenderEnum;
import com.bwang.join.dao.entity.Message;
import com.bwang.join.dao.entity.User;
import com.bwang.join.dao.entity.UserGroup;
import com.bwang.join.util.BeanHelper;
import com.bwang.join.util.ServiceException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * User: Brian Wang
 * Time: 2/2/14 10:05 PM
 */
public class RestfulServiceTestCase {
    private static Logger logger = LoggerFactory.getLogger(RestfulServiceTestCase.class);

    private RestfulService service;
    private final static String TEST_USER_EMAIL = "pawincn@gmail.com";
    private final static String TEST_GROUP_NAME = "badminton";
    private final static String TEST_ACTIVITY_TITLE = "Run for health around community";

    public RestfulServiceTestCase() {
        service = (RestfulService) BeanHelper.getBean("restfulService");
    }

    @Test
    public void testSaveUser() {
        UserDto user = new UserDto();
        user.setFirstName("Dou");
        user.setLastName("Wang");
        user.setEmail(TEST_USER_EMAIL);
        service.saveUser(user);
    }

    @Test
    public void testFindUserByEmail() {
        UserDto user = service.findUserByEmail(TEST_USER_EMAIL);
        assertEquals(TEST_USER_EMAIL, user.getEmail());

    }

    @Test
    public void testSaveGroup() {
        GroupDto group = new GroupDto();
        group.setName(TEST_GROUP_NAME);
        service.saveGroup(group);
    }

    @Test
    public void testFindGroup() {
        GroupDto group = service.findGroupByName(TEST_GROUP_NAME);
        assertEquals(TEST_GROUP_NAME, group.getName());
    }

    // depends on the fetch mode of user's groups, this case works in JOIN mode of many-to-many.
    /*@Test
    public void testSaveUserGroupRelationship() {
        User user = service.findUserByEmail(TEST_USER_EMAIL);
        UserGroup group = service.findGroupByName(TEST_GROUP_NAME);
        user.addGroup(group);
        service.saveUser(user);
    }*/

    @Test
    public void testFindUserGroups() {
        Set<UserGroup> groups = service.findGroupsByUserEmail(TEST_USER_EMAIL);
        assertNotNull(groups);
        logger.info("group's size: " + groups.size());
    }

    @Test
    public void testSaveUserGroupRef() {
        UserGroupsDto ref = new UserGroupsDto();
        ref.setUserId(1l);
        service.saveUserGroupRef(ref);
    }

    @Test
    public void testSaveActivityRestriction() {
        ActivityRestriction restriction = new ActivityRestriction();
        restriction.setDistance(1);
        restriction.setAgeMax(60);
        restriction.setAgeMin(16);
        restriction.setParticipantCountMax(100);
        restriction.setParticipantGender(GenderEnum.Female);
        restriction.setStartAtTime(new Date());
//        restriction.setStartAtTime(DateTime.now().plusHours(1));
//        service.saveActivityRestriction(restriction);
    }

    @Test
    public void testSaveActivityRecurringSetting() {
        ActivityRecurringSetting setting = new ActivityRecurringSetting();
        setting.setMondaySupported(true);
        setting.setStartTime("12:00");
        setting.setRecurringEnd(new Date());
//        service.saveActivityRecurringSetting(setting);
    }

    @Test
    public void testSaveActivityLocation() {
        ActivityLocation location = new ActivityLocation();
        location.setLatitude(30.0000);
        location.setLongitude(120.0000);
        location.setAddress("LOTUS COMMUNITY");
//        service.saveActivityLocation(location);
    }

    @Test
    public void testSaveActivity() throws ServiceException {
        ActivityDto activity = new ActivityDto();
        activity.setTitle(TEST_ACTIVITY_TITLE);
        activity.setDesc("Go outdoor and run with your family.");

        activity.setDistanceInKm(1);
        activity.setStartTime("12:00:00");

        activity.setLatitude(33.0000);
        activity.setLongitude(120.0000);

        activity.setOrganizerId(1l);

        service.saveActivity(activity);
    }

    @Test
    public void testFindActivities() {
        List<ActivityDto> activityList = service.findActivitiesByTitle(TEST_ACTIVITY_TITLE);
        if (CollectionUtils.isEmpty(activityList)) {
            return;
        }
        for (ActivityDto activity : activityList) {
            assertNotNull(activity);
            /*assertNotNull(activity.getLocation());
            assertNotNull(activity.getRestriction());
            assertNotNull(activity.getOrganizer());*/
        }
    }

    @Test
    public void testFindActivityInvitees() {
        List<ActivityInvitee> invitees = service.findActivityInvitees(2l);
        assertNotNull(invitees);
    }

    @Test
    public void testFindActivityJoiners() {
        List<ActivityJoiner> joiners = service.findActivityJoiners(2l);
        assertNotNull(joiners);
    }

    @Test
    public void testSendMessage() {
        Message msg = new Message();
        msg.setMessage("Some funny news from Brian...");

        Set<User> receivers = new HashSet<User>();
        receivers.add(new User(service.findUserByEmail(TEST_USER_EMAIL)));

        service.sendMessage(msg, receivers);
    }
}
