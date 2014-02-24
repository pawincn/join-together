package com.bwang.join.service.impl;

import com.bwang.join.dao.EntityDao;
import com.bwang.join.dao.entity.Participant;
import com.bwang.join.service.RestfulService;
import org.springframework.transaction.annotation.Transactional;

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
    public void saveParticipant(Participant participant) {
        entityDao.save(participant);
    }
}
