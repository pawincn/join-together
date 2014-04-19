package com.bwang.join.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Author: Brian Wang
 * Date: 3/29/14 4:02 PM
 */
@Entity
@Table(name = "user_footprints")
public class UserFootprint extends AbstractEntity {
    @Column(name = "longitude")
    private double longitude;

    @Column(name = "latitude")
    private double latitude;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
