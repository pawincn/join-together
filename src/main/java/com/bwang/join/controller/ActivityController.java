package com.bwang.join.controller;

import com.bwang.join.controller.dto.ActivityDto;
import com.bwang.join.service.RestfulService;
import com.bwang.join.util.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: Brian Wang
 * Date: 3/15/14 2:10 PM
 */
@RestController
public class ActivityController {
    @Autowired private RestfulService service;

    @RequestMapping(value = "activities", method = RequestMethod.POST)
    public void saveActivity(ActivityDto activity) throws ServiceException {
        service.saveActivity(activity);
    }

    @RequestMapping(value = "activities/{title}", method = RequestMethod.GET)
    public List<ActivityDto> findActivityByTitle(@PathVariable("title") String title) {
        return service.findActivitiesByTitle(title);
    }
}
