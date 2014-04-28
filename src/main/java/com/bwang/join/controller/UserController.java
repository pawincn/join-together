package com.bwang.join.controller;

import com.bwang.join.controller.dto.GroupDto;
import com.bwang.join.controller.dto.GroupUsersDto;
import com.bwang.join.controller.dto.UserDto;
import com.bwang.join.controller.dto.UserGroupsDto;
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
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired private RestfulService service;

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void saveUser(@RequestBody UserDto user) {
        logger.info("save or update user : {}", user.getEmail());
        service.saveUser(user);
    }

    @RequestMapping(value = "/users/{email:.+}", method = RequestMethod.GET)
    public UserDto findUserByEmail(@PathVariable String email) {
        logger.info("email to retrieve user is : {}", email);
        return service.findUserByEmail(email);
    }

    @RequestMapping(value = "/groups", method = RequestMethod.POST)
    public void saveGroup(@RequestBody GroupDto group) {
        logger.info("save or update group : {}", group.getName());
        service.saveGroup(group);
    }

    @RequestMapping(value = "/groups/{name}", method = RequestMethod.GET)
    public GroupDto findGroupByName(@PathVariable("name") String name) {
        logger.info("find group by name : {}", name);
        return service.findGroupByName(name);
    }

    @RequestMapping(value = "/user_groups", method = RequestMethod.POST)
    public void saveUserGroups(@RequestBody UserGroupsDto dto) {
        logger.info("save or update groups {} of user {}", dto.getGroupIds(), dto.getUserId());
        service.saveUserGroupRef(dto);
    }

    @RequestMapping(value = "/group_users", method = RequestMethod.POST)
    public void saveGroupUsers(@RequestBody GroupUsersDto dto) {
        logger.info("save or update users {} of group {}", dto.getUserIds(), dto.getGroupId());
        service.saveGroupUserRef(dto);
    }
}
