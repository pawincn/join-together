package com.bwang.join.dao;

import com.bwang.join.controller.dto.ActivityDto;
import com.bwang.join.dao.entity.AbstractEntity;
import com.bwang.join.dao.entity.Activity;
import com.bwang.join.dao.entity.ActivityInvitee;
import com.bwang.join.dao.entity.ActivityJoiner;
import com.bwang.join.dao.entity.ActivityLocation;
import com.bwang.join.dao.entity.ActivityRecurringSetting;
import com.bwang.join.dao.entity.ActivityRestriction;
import com.bwang.join.dao.entity.GenderEnum;
import com.bwang.join.dao.entity.Message;
import com.bwang.join.dao.entity.MessageReceiver;
import com.bwang.join.dao.entity.User;
import com.bwang.join.dao.entity.UserGroup;
import com.bwang.join.dao.entity.UserGroupRef;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: Brian Wang
 * Time: 1/8/14 11:24 PM
 */
public class EntityDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    protected Session getSession() {
        return getSessionFactory().getCurrentSession();
    }

    public void save(AbstractEntity entity) {
        getSession().saveOrUpdate(entity);
    }

    public <T> T loadEntity(Class<T> clazz, Long id) {
        return (T) getSession().load(clazz, id);
    }

    /**
     * Get always hit DB, load just return a fake instance with given id.
     * Also parametrize the class type.
     */
    @SuppressWarnings("unchecked")
    public <T> T findById(Class<T> clazz, Long id) {
        return (T) getSession().get(clazz, id);
    }

    @SuppressWarnings("unchecked")
    public User findUserByEmail(String email) {
        List<User> users = getSession().createCriteria(User.class)
                .add(Restrictions.eq("email", email)).list();
        return CollectionUtils.isEmpty(users) ? null : users.get(0);
    }

    @SuppressWarnings("unchecked")
    public Set<UserGroup> findUserGroupsByUserEmail(String email) {
        User user = findUserByEmail(email);
        List<UserGroupRef> groupRefs = getSession().createCriteria(UserGroupRef.class)
                .add(Restrictions.eq("user", user)).list();
        Set<UserGroup> groups = null;
        if (!CollectionUtils.isEmpty(groupRefs)) {
            groups = new HashSet<UserGroup>();
            for (UserGroupRef ref : groupRefs) {
                groups.add(ref.getGroup());
            }
        }
        return groups;
    }

    @SuppressWarnings("unchecked")
    public UserGroup findUserGroupByName(String groupName) {
        List<UserGroup> groups = getSession().createCriteria(UserGroup.class)
                .add(Restrictions.eq("groupName", groupName)).list();
        return CollectionUtils.isEmpty(groups) ? null : groups.get(0);
    }

    @SuppressWarnings("unchecked")
    public List<Activity> findActivitiesByTitle(String activityTitle) {
        return getSession().createCriteria(Activity.class)
                .add(Restrictions.eq("title", activityTitle)).list();
    }

    @SuppressWarnings("unchecked")
    public List<ActivityInvitee> findActivityInvitees(Long activityId) {
        Activity activity = findById(Activity.class, activityId);
        return getSession().createCriteria(ActivityInvitee.class)
                .add(Restrictions.eq("dto", activity)).list();
    }

    @SuppressWarnings("unchecked")
    public List<ActivityJoiner> findActivityJoiners(Long activityId) {
        Activity activity = findById(Activity.class, activityId);
        // below method should work if fetch mode is JOIN
        // return dto.getJoiners();

        return getSession().createCriteria(ActivityJoiner.class)
                .add(Restrictions.eq("dto", activity)).list();
    }

    public void sendMessage(Message message, Set<User> receivers) {
        save(message);
        if (!CollectionUtils.isEmpty(receivers)) {
            for (User receiver : receivers) {
                save(new MessageReceiver(message, receiver));
            }
        }
    }

}
