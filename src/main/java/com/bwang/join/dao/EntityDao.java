package com.bwang.join.dao;

import com.bwang.join.dao.entity.AbstractEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
}
