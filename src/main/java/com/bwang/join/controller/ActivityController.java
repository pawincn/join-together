package com.bwang.join.controller;

import com.bwang.join.dao.entity.Activity;
import com.bwang.join.service.RestfulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: Brian Wang
 * Date: 3/15/14 2:10 PM
 */
@Controller
@RequestMapping("activity")
public class ActivityController {
    @Autowired private RestfulService service;

    public void saveActivity(Activity activity) {
        service.saveActivity(activity);
    }
}
