package com.tjCourse.softwareEngineering.backend.dao.repository;

import com.tjCourse.softwareEngineering.backend.pojo.Appointment;
import com.tjCourse.softwareEngineering.backend.pojo.AppointmentPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AppointmentRepository extends JpaRepository<Appointment, AppointmentPK> {
    public Integer countByActivityId(Integer activityID);

    public Appointment getAllByActivityIdAndUserId(Integer activityId,Integer userId);
}
