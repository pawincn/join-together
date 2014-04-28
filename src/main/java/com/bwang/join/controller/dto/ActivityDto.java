package com.bwang.join.controller.dto;

import java.util.Date;

/**
 * Author: Brian Wang
 * Date: 4/26/14 7:39 AM
 */
public class ActivityDto {
    private Long id;
    private String title;
    private String desc;

    private Double longitude;
    private Double latitude;
    private String address;
    private String city;
    private String province;
    private String country;

    private Integer distanceInKm;
    private Integer participantMax;
    private String participantGender;
    private Integer ageMin;
    private Integer ageMax;
    private Integer startInMinutes;
    private Date startAtTime;

    private String startTime;
    private Date recurringEnd;
    private Boolean mondaySupported;
    private Boolean tuesdaySupported;
    private Boolean wednesdaySupported;
    private Boolean thursdaySupported;
    private Boolean fridaySupported;
    private Boolean saturdaySupported;
    private Boolean sundaySupported;

    private String tags;

    private Long organizerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
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

    public Integer getDistanceInKm() {
        return distanceInKm;
    }

    public void setDistanceInKm(Integer distanceInKm) {
        this.distanceInKm = distanceInKm;
    }

    public Integer getParticipantMax() {
        return participantMax;
    }

    public void setParticipantMax(Integer participantMax) {
        this.participantMax = participantMax;
    }

    public String getParticipantGender() {
        return participantGender;
    }

    public void setParticipantGender(String participantGender) {
        this.participantGender = participantGender;
    }

    public Integer getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(Integer ageMin) {
        this.ageMin = ageMin;
    }

    public Integer getAgeMax() {
        return ageMax;
    }

    public void setAgeMax(Integer ageMax) {
        this.ageMax = ageMax;
    }

    public Integer getStartInMinutes() {
        return startInMinutes;
    }

    public void setStartInMinutes(Integer startInMinutes) {
        this.startInMinutes = startInMinutes;
    }

    public Date getStartAtTime() {
        return startAtTime;
    }

    public void setStartAtTime(Date startAtTime) {
        this.startAtTime = startAtTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Date getRecurringEnd() {
        return recurringEnd;
    }

    public void setRecurringEnd(Date recurringEnd) {
        this.recurringEnd = recurringEnd;
    }

    public Boolean getMondaySupported() {
        return mondaySupported;
    }

    public void setMondaySupported(Boolean mondaySupported) {
        this.mondaySupported = mondaySupported;
    }

    public Boolean getTuesdaySupported() {
        return tuesdaySupported;
    }

    public void setTuesdaySupported(Boolean tuesdaySupported) {
        this.tuesdaySupported = tuesdaySupported;
    }

    public Boolean getWednesdaySupported() {
        return wednesdaySupported;
    }

    public void setWednesdaySupported(Boolean wednesdaySupported) {
        this.wednesdaySupported = wednesdaySupported;
    }

    public Boolean getThursdaySupported() {
        return thursdaySupported;
    }

    public void setThursdaySupported(Boolean thursdaySupported) {
        this.thursdaySupported = thursdaySupported;
    }

    public Boolean getFridaySupported() {
        return fridaySupported;
    }

    public void setFridaySupported(Boolean fridaySupported) {
        this.fridaySupported = fridaySupported;
    }

    public Boolean getSaturdaySupported() {
        return saturdaySupported;
    }

    public void setSaturdaySupported(Boolean saturdaySupported) {
        this.saturdaySupported = saturdaySupported;
    }

    public Boolean getSundaySupported() {
        return sundaySupported;
    }

    public void setSundaySupported(Boolean sundaySupported) {
        this.sundaySupported = sundaySupported;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Long getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(Long organizerId) {
        this.organizerId = organizerId;
    }
}
