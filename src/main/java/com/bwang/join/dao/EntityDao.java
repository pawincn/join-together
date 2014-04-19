package com.bwang.join.dao;

import com.bwang.join.dao.entity.AbstractEntity;
import com.bwang.join.dao.entity.Activity;
import com.bwang.join.dao.entity.User;
import com.bwang.join.dao.entity.UserGroup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.CollectionUtils;

import java.util.List;

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

    public UserGroup findUserGroupByName(String groupName) {
        List<UserGroup> groups = getSession().createCriteria(UserGroup.class)
                .add(Restrictions.eq("groupName", groupName)).list();
        return CollectionUtils.isEmpty(groups) ? null : groups.get(0);
    }

    public Activity findActivityByName(String activityName) {
        List<Activity> activities = getSession().createCriteria(Activity.class)
                .add(Restrictions.eq("title", activityName)).list();
        return CollectionUtils.isEmpty(activities) ? null : activities.get(0);
    }
}
