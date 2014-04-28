package com.bwang.join.dao.entity;

import com.bwang.join.controller.dto.ActivityDto;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Set;

/**
 * Author: Brian Wang
 * Date: 3/15/14 4:58 PM
 */
@Entity
@Table(name = "activities")
public class Activity extends AbstractEntity {
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;

    @ManyToOne
//    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "restriction_id", nullable = true)
    private ActivityRestriction restriction;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = true)
    private ActivityLocation location;

    @OneToOne
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "organizer_id", nullable = true)
    private User organizer;

    @OneToMany(mappedBy = "activity")
    @Fetch(FetchMode.SELECT)
    private Set<ActivityInvitee> invitees;

    @OneToMany(mappedBy = "activity")
    @Fetch(FetchMode.SELECT)
    private Set<ActivityJoiner> joiners;

    public Activity() {}

    public Activity(ActivityDto dto) {
        this.setId(dto.getId());
        this.setTitle(dto.getTitle());
        this.setDescription(dto.getDesc());
    }

    public Set<ActivityJoiner> getJoiners() {
        return joiners;
    }

    public void setJoiners(Set<ActivityJoiner> joiners) {
        this.joiners = joiners;
    }

    public Set<ActivityInvitee> getInvitees() {
        return invitees;
    }

    public void setInvitees(Set<ActivityInvitee> invitees) {
        this.invitees = invitees;
    }

    public User getOrganizer() {
        return organizer;
    }

    public void setOrganizer(User organizer) {
        this.organizer = organizer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ActivityRestriction getRestriction() {
        return restriction;
    }

    public void setRestriction(ActivityRestriction restriction) {
        this.restriction = restriction;
    }

    public ActivityLocation getLocation() {
        return location;
    }

    public void setLocation(ActivityLocation location) {
        this.location = location;
    }

    public ActivityDto toActivityDto() {
        ActivityDto dto = new ActivityDto();
        dto.setId(this.getId());
        dto.setTitle(this.getTitle());
        dto.setDesc(this.getDescription());
        // add activities other info into DTO
        ActivityLocation loc = this.getLocation();
        if (loc != null) {
            dto.setLongitude(loc.getLongitude());
            dto.setLatitude(loc.getLatitude());
            dto.setAddress(loc.getAddress());
            dto.setCity(loc.getCity());
            dto.setProvince(loc.getProvince());
            dto.setCountry(loc.getCountry());
        }
        ActivityRestriction res = this.getRestriction();
        if (res != null) {
            dto.setDistanceInKm(res.getDistance());
            dto.setParticipantMax(res.getParticipantCountMax());
            dto.setParticipantGender(
                    res.getParticipantGender() == null ?
                            null : res.getParticipantGender().name());
            dto.setAgeMax(res.getAgeMax());
            dto.setAgeMin(res.getAgeMin());
            dto.setStartInMinutes(res.getStartInMinutes());
            dto.setStartAtTime(res.getStartAtTime());
            ActivityRecurringSetting set = res.getRecurringSetting();
            if (set != null) {
                dto.setStartTime(set.getStartTime());
                dto.setRecurringEnd(set.getRecurringEnd());
                dto.setMondaySupported(set.getMondaySupported());
                dto.setTuesdaySupported(set.getTuesdaySupported());
                dto.setWednesdaySupported(set.getWednesdaySupported());
                dto.setThursdaySupported(set.getThursdaySupported());
                dto.setFridaySupported(set.getFridaySupported());
                dto.setSaturdaySupported(set.getSaturdaySupported());
                dto.setSundaySupported(set.getSundaySupported());
            }
        }

        return dto;
    }
}
