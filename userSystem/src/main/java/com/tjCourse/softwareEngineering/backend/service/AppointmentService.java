package com.tjCourse.softwareEngineering.backend.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Service;

public interface AppointmentService {
    public Integer countByActivityId(Integer activityID);

    public Boolean addAppointment(Integer user_ID,Integer activity_ID);

    public Boolean deleteAppointment(Integer user_ID, Integer activity_ID);
}
