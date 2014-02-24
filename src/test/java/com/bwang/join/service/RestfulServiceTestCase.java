package com.bwang.join.service;

import com.bwang.join.dao.entity.Participant;
import com.bwang.join.util.BeanHelper;
import org.junit.Test;

/**
 * User: Brian Wang
 * Time: 2/2/14 10:05 PM
 */
public class RestfulServiceTestCase {
    private RestfulService service;

    public RestfulServiceTestCase() {
        service = (RestfulService) BeanHelper.getBean("restfulService");
    }

    @Test
    public void testSaveParticipant() {
        Participant entity = new Participant();
        entity.setFirstName("Dou");
        entity.setLastName("Wang");
        entity.setEmail("pawincn@gmail.com");
        service.saveParticipant(entity);
    }
}
