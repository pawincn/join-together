package com.bwang.join.controller.dto;

import com.bwang.join.dao.entity.User;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Author: Brian Wang
 * Date: 4/23/14 8:44 PM
 */
public class UserDto {
    private String nickName;
    private String firstName;
    private String lastName;
    private String gender;
    private Integer age;
    private String email;
    private String mobile;
    private String wechat;
    private String weibo;

    public UserDto() {}

    public UserDto(User user) {
        this.nickName = user.getNickName();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.gender = user.getGender() == null ? null : user.getGender().name();
        this.age = user.getAge();
        this.email = user.getEmail();
        this.mobile = user.getMobileNumber();
        this.wechat = user.getWechatId();
        this.weibo = user.getWeiboId();
    }

    public String getWeibo() {
        return weibo;
    }

    public void setWeibo(String weibo) {
        this.weibo = weibo;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }
}
