package com.bwang.join.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Author: Brian Wang
 * Date: 4/6/14 10:14 PM
 */
@Entity
@Table(name = "activity_location")
public class ActivityLocation extends AbstractEntity {
    @Column(name = "longitude")
    private double longitude;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "province")
    private String province;
    @Column(name = "country")
    private String country;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
