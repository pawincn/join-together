package com.bwang.join.dao;

import com.bwang.join.dao.entity.Participant;
import com.bwang.join.util.BeanHelper;
import org.junit.Test;


/**
 * User: Brian Wang
 * Time: 1/12/14 11:13 PM
 */
public class EntityDaoTestCase {
    private EntityDao dao;

    public EntityDaoTestCase() {
        dao = (EntityDao) BeanHelper.getBean("entityDao");
    }

    @Test
    public void testSave() {
        Participant entity = new Participant();
        entity.setId(2l);
        entity.setFirstName("Brian");
        entity.setLastName("Wang");
        entity.setEmail("pawincn@gmail.com");
        dao.save(entity);
    }

    @Test
    public void testFindById() {
        dao.findById(Participant.class, 1l);
    }
}
