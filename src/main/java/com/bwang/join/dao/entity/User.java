package com.bwang.join.dao.entity;

import com.bwang.join.controller.dto.UserDto;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
    @Enumerated(EnumType.ORDINAL)
    private GenderEnum gender;

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
    @Fetch(FetchMode.SELECT)
    @JoinTable(
            name = "user_group_xref",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Set<UserGroup> groups;*/
    @OneToMany(mappedBy = "user")
    @Fetch(FetchMode.SELECT)
    private Set<UserGroupRef> groupRefs;

    public User() {}

    public User(UserDto dto) {
        this.setId(dto.getId());
        this.setNickName(dto.getNickName());
        this.setFirstName(dto.getFirstName());
        this.setLastName(dto.getLastName());
        GenderEnum gender = dto.getGender() == null ?
                null : GenderEnum.valueOf(dto.getGender());
        this.setGender(gender);
        this.setAge(dto.getAge());
        this.setEmail(dto.getEmail());
        this.setMobileNumber(dto.getMobile());
        this.setWechatId(dto.getWechat());
        this.setWeiboId(dto.getWeibo());
    }

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

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
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

    public UserDto toUserDto() {
        UserDto dto = new UserDto();
        dto.setId(this.getId());
        dto.setNickName(this.getNickName());
        dto.setFirstName(this.getFirstName());
        dto.setLastName(this.getLastName());
        dto.setGender(this.getGender() == null ? null : this.getGender().name());
        dto.setAge(this.getAge());
        dto.setEmail(this.getEmail());
        dto.setMobile(this.getMobileNumber());
        dto.setWechat(this.getWechatId());
        dto.setWeibo(this.getWeiboId());
        return dto;
    }
}
