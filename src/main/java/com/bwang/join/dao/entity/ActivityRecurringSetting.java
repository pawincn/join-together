package com.bwang.join.dao.entity;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;

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
    private boolean monday;
    @Column(name = "tuesday")
    private boolean tuesday;
    @Column(name = "wednesday")
    private boolean wednesday;
    @Column(name = "thursday")
    private boolean thursday;
    @Column(name = "friday")
    private boolean friday;
    @Column(name = "saturday")
    private boolean saturday;
    @Column(name = "sunday")
    private boolean sunday;

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

    public boolean isMonday() {
        return monday;
    }

    public void setMonday(boolean monday) {
        this.monday = monday;
    }

    public boolean isTuesday() {
        return tuesday;
    }

    public void setTuesday(boolean tuesday) {
        this.tuesday = tuesday;
    }

    public boolean isWednesday() {
        return wednesday;
    }

    public void setWednesday(boolean wednesday) {
        this.wednesday = wednesday;
    }

    public boolean isThursday() {
        return thursday;
    }

    public void setThursday(boolean thursday) {
        this.thursday = thursday;
    }

    public boolean isFriday() {
        return friday;
    }

    public void setFriday(boolean friday) {
        this.friday = friday;
    }

    public boolean isSaturday() {
        return saturday;
    }

    public void setSaturday(boolean saturday) {
        this.saturday = saturday;
    }

    public boolean isSunday() {
        return sunday;
    }

    public void setSunday(boolean sunday) {
        this.sunday = sunday;
    }
}
