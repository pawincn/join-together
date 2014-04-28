package com.bwang.join.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Author: Brian Wang
 * Date: 3/15/14 5:23 PM
 */
@Entity
@Table(name = "activity_recurring_settings")
public class ActivityRecurringSetting extends AbstractEntity {
    @Column(name = "start_time")
    private String startTime;
    @Column(name = "recurring_end")
    private Date recurringEnd;
    @Column(name = "monday")
    private Boolean mondaySupported;
    @Column(name = "tuesday")
    private Boolean tuesdaySupported;
    @Column(name = "wednesday")
    private Boolean wednesdaySupported;
    @Column(name = "thursday")
    private Boolean thursdaySupported;
    @Column(name = "friday")
    private Boolean fridaySupported;
    @Column(name = "saturday")
    private Boolean saturdaySupported;
    @Column(name = "sunday")
    private Boolean sundaySupported;

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
}
