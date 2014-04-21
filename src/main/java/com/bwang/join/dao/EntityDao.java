package com.bwang.join.dao;

import com.bwang.join.dao.entity.AbstractEntity;
import com.bwang.join.dao.entity.Activity;
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

    /**
     * Get always hit DB, load just return a fake instance with given id.
     * Also parametrize the class type.
     */
    public <T> T findById(Class<T> clazz, Long id) {
        return (T) getSession().get(clazz, id);
    }

    public User findUserByEmail(String email) {
        List<User> users = getSession().createCriteria(User.class)
                .add(Restrictions.eq("email", email)).list();
        return CollectionUtils.isEmpty(users) ? null : users.get(0);
    }

    public Set<UserGroup> findUserGroupsByUserEmail(String email) {
        User user = findUserByEmail(email);
        List<UserGroupRef> groupRefs = getSession().createCriteria(UserGroupRef.class)
                .add(Restrictions.eq("user", user)).list();
        Set<UserGroup> groups = null;
        if (!CollectionUtils.isEmpty(groupRefs)) {
            groups = new HashSet<>();
            for (UserGroupRef ref : groupRefs) {
                groups.add(ref.getGroup());
            }
        }
        return groups;
    }

    public UserGroup findUserGroupByName(String groupName) {
        List<UserGroup> groups = getSession().createCriteria(UserGroup.class)
                .add(Restrictions.eq("groupName", groupName)).list();
        return CollectionUtils.isEmpty(groups) ? null : groups.get(0);
    }

    public List<Activity> findActivitiesByTitle(String activityTitle) {
        List<Activity> activities = getSession().createCriteria(Activity.class)
                .add(Restrictions.eq("title", activityTitle)).list();
        return activities;
    }

    public List<User> findActivityParticipants(Activity activity) {
        return null;
    }
}
