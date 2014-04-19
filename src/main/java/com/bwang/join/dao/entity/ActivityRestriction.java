package com.bwang.join.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * Author: Brian Wang
 * Date: 3/15/14 5:05 PM
 */
@Entity
@Table(name = "activity_restrictions")
public class ActivityRestriction extends AbstractEntity {
    @Column(name = "distance_in_km")
    private Integer distance;
    @Column(name = "participant_count_max")
    private Integer participantCountMax;

    @Column(name = "participant_gender")
    @Enumerated(EnumType.ORDINAL)
    private GenderEnum participantGender;

    @Column(name = "age_range_max")
    private Integer maxAge;
    @Column(name = "age_range_min")
    private Integer minAge;
    @Column(name = "start_in_minutes")
    private Integer startInMinutes;
    @Column(name = "start_at_datetime")
//    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
//    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private Date startTime;

    @ManyToOne
    @JoinColumn(name = "recurring_setting_id", nullable = true)
    private ActivityRecurringSetting recurringSetting;

    public enum GenderEnum {
        Male,
        Female
    }

    public ActivityRecurringSetting getRecurringSetting() {
        return recurringSetting;
    }

    public void setRecurringSetting(ActivityRecurringSetting recurringSetting) {
        this.recurringSetting = recurringSetting;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getParticipantCountMax() {
        return participantCountMax;
    }

    public void setParticipantCountMax(Integer participantCountMax) {
        this.participantCountMax = participantCountMax;
    }

    public GenderEnum getParticipantGender() {
        return participantGender;
    }

    public void setParticipantGender(GenderEnum participantGender) {
        this.participantGender = participantGender;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Integer getStartInMinutes() {
        return startInMinutes;
    }

    public void setStartInMinutes(Integer startInMinutes) {
        this.startInMinutes = startInMinutes;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
