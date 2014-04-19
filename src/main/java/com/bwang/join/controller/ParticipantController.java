package com.bwang.join.controller;

import com.bwang.join.dao.entity.User;
import com.bwang.join.service.RestfulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: Brian Wang
 * Time: 2/5/14 11:29 AM
 */
@Controller
@RequestMapping("/participant")
public class ParticipantController {
    @Autowired private RestfulService service;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public @ResponseBody
    User findParticipantById(@PathVariable String email) {
        return service.findUserByEmail(email);
    }
}
