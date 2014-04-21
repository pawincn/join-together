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

import java.util.ArrayList;
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

    public Object findById(Class clazz, Long id) {
        return getSession().get(clazz, id);
    }

    public User findUserByEmail(String email) {
        List<User> users = getSession().createCriteria(User.class)
                .add(Restrictions.eq("email", email)).list();
        return CollectionUtils.isEmpty(users) ? null : users.get(0);
    }

    public Set<UserGroup> findUserGroups(String email) {
        Session session = getSession();
        List<User> users = session.createCriteria(User.class)
                .add(Restrictions.eq("email", email)).list();
        User user = CollectionUtils.isEmpty(users) ? null : users.get(0);
        return user == null ? null : user.getGroups();
    }

    public UserGroup findUserGroupByName(String groupName) {
        List<UserGroup> groups = getSession().createCriteria(UserGroup.class)
                .add(Restrictions.eq("groupName", groupName)).list();
        return CollectionUtils.isEmpty(groups) ? null : groups.get(0);
    }

    public List<Activity> findActivityByTitle(String activityTitle) {
        List<Activity> activities = getSession().createCriteria(Activity.class)
                .add(Restrictions.eq("title", activityTitle)).list();
        return activities == null ? new ArrayList<Activity>(0) : activities;
    }
}
