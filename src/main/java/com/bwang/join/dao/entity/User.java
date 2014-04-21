package com.bwang.join.dao.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Brian Wang
 * Time: 1/8/14 11:20 PM
 */
@Entity
@Table(name = "users")
public class User extends AbstractEntity {
    @Column(name = "nick_name")
    private String nickName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "gender")
    private Integer gender;
    @Column(name = "age")
    private Integer age;
    @Column(name = "email")
    private String email;
    @Column(name = "mobile_number")
    private String mobileNumber;
    @Column(name = "wechat_id")
    private String wechatId;
    @Column(name = "weibo_id")
    private String weiboId;

    /*@ManyToMany
    @Fetch(FetchMode.SELECT)  // todo default the value later
    @JoinTable(
            name = "user_group_xref",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Set<UserGroup> groups;*/

    @OneToMany(mappedBy = "user")
    @Fetch(FetchMode.SELECT)
    private Set<UserGroupRef> groupRefs;

    public Set<UserGroupRef> getGroupRefs() {
        return groupRefs;
    }

    public void setGroupRefs(Set<UserGroupRef> groupRefs) {
        this.groupRefs = groupRefs;
    }

    public void addGroupRef(UserGroupRef groupRef) {
        if (this.groupRefs == null) {
            this.groupRefs = new HashSet<UserGroupRef>();
        }
        this.groupRefs.add(groupRef);
    }

    /*public Set<UserGroup> getGroups() {
        return groups;
    }

    public void setGroups(Set<UserGroup> groups) {
        this.groups = groups;
    }

    public void addGroup(UserGroup group) {
        if (this.groups == null) {
            this.groups = new HashSet<UserGroup>();
        }
        this.groups.add(group);
    }*/

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public String getWeiboId() {
        return weiboId;
    }

    public void setWeiboId(String weiboId) {
        this.weiboId = weiboId;
    }
}
