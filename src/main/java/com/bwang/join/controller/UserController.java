package com.bwang.join.controller;

import com.bwang.join.controller.dto.UserDto;
import com.bwang.join.dao.entity.User;
import com.bwang.join.service.RestfulService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: Brian Wang
 * Time: 2/5/14 11:29 AM
 */
@RestController
@RequestMapping("/users")
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired private RestfulService service;

    @RequestMapping(method = RequestMethod.POST)
    public void saveUser(@RequestBody UserDto user) {
        logger.info("save or update user : {}", user.getEmail());
        service.saveUser(user);
    }

    @RequestMapping(value = "{email:.+}", method = RequestMethod.GET)
    public UserDto findUserByEmail(@PathVariable String email) {
        logger.info("email to retrieve user is : {}", email);
        return service.findUserByEmail(email);
    }
}
