package com.bwang.join.service;

import com.bwang.join.dao.entity.Activity;
import com.bwang.join.dao.entity.ActivityLocation;
import com.bwang.join.dao.entity.ActivityRecurringSetting;
import com.bwang.join.dao.entity.ActivityRestriction;
import com.bwang.join.dao.entity.User;
import com.bwang.join.dao.entity.UserGroup;
import com.bwang.join.dao.entity.UserGroupRef;
import com.bwang.join.util.BeanHelper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.Date;
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
        User user = new User();
        user.setFirstName("Dou");
        user.setLastName("Wang");
        user.setEmail(TEST_USER_EMAIL);
        service.saveUser(user);
    }

    @Test
    public void testFindUserByEmail() {
        User user = service.findUserByEmail(TEST_USER_EMAIL);
        assertEquals(TEST_USER_EMAIL, user.getEmail());

    }

    @Test
    public void testSaveGroup() {
        UserGroup group = new UserGroup();
        group.setGroupName(TEST_GROUP_NAME);
        service.saveUserGroup(group);
    }

    @Test
    public void testFindGroup() {
        UserGroup group = service.findUserGroupByName(TEST_GROUP_NAME);
        assertEquals(TEST_GROUP_NAME, group.getGroupName());
    }

    // depends on the fetch mode of user's groups, this case works in JOIN mode of many-to-many.
    /*@Test
    public void testSaveUserGroupRelationship() {
        User user = service.findUserByEmail(TEST_USER_EMAIL);
        UserGroup group = service.findUserGroupByName(TEST_GROUP_NAME);
        user.addGroup(group);
        service.saveUser(user);
    }*/

    @Test
    public void testFindUserGroups() {
        Set<UserGroup> groups = service.findUserGroupsByUserEmail(TEST_USER_EMAIL);
        assertNotNull(groups);
        logger.info("group's size: " + groups.size());
    }

    @Test
    public void testSaveUserGroupRef() {
        User user = service.findUserByEmail(TEST_USER_EMAIL);
        UserGroup group = service.findUserGroupByName(TEST_GROUP_NAME);
        UserGroupRef ref = new UserGroupRef(user, group);
        service.saveUserGroupRef(ref);
    }

    @Test
    public void testSaveActivityRestriction() {
        ActivityRestriction restriction = new ActivityRestriction();
        restriction.setDistance(1);
        restriction.setMaxAge(60);
        restriction.setMinAge(16);
        restriction.setParticipantCountMax(100);
        restriction.setParticipantGender(ActivityRestriction.GenderEnum.Female);
        restriction.setStartTime(new Date());
//        restriction.setStartTime(DateTime.now().plusHours(1));
        service.saveActivityRestriction(restriction);
    }

    @Test
    public void testSaveActivityRecurringSetting() {
        ActivityRecurringSetting setting = new ActivityRecurringSetting();
        setting.setMonday(true);
        setting.setStartTime("12:00");
        setting.setRecurringEnd(new Date());
        service.saveActivityRecurringSetting(setting);
    }

    @Test
    public void testSaveActivityLocation() {
        ActivityLocation location = new ActivityLocation();
        location.setLatitude(30.0000);
        location.setLongitude(120.0000);
        location.setAddress("LOTUS COMMUNITY");
        service.saveActivityLocation(location);
    }

    @Test
    public void testSaveActivity() {
        Activity activity = new Activity();
        activity.setTitle(TEST_ACTIVITY_TITLE);
        activity.setDescription("Go outdoor and run with your family.");

        ActivityRestriction restriction = new ActivityRestriction();
        restriction.setDistance(1);
        restriction.setStartTime(new Date());
        service.saveActivityRestriction(restriction);
        activity.setRestriction(restriction);

        ActivityLocation location = new ActivityLocation();
        location.setLatitude(33.0000);
        location.setLongitude(120.0000);
        service.saveActivityLocation(location);
        activity.setLocation(location);

        User organizer = service.findUserByEmail(TEST_USER_EMAIL);
        activity.setOrganizer(organizer);

        service.saveActivity(activity);
    }

    @Test
    public void testFindActivities() {
        List<Activity> activityList = service.findActivitiesByTitle(TEST_ACTIVITY_TITLE);
        if (CollectionUtils.isEmpty(activityList)) {
            return;
        }
        for (Activity activity : activityList) {
            assertNotNull(activity);
            assertNotNull(activity.getLocation());
            assertNotNull(activity.getRestriction());
            assertNotNull(activity.getOrganizer());
        }
    }

}
