package com.tjCourse.softwareEngineering.backend.dao.repository;

import com.tjCourse.softwareEngineering.backend.entity.Appointment;
import com.tjCourse.softwareEngineering.backend.entity.AppointmentPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, AppointmentPK> {
    public Integer countByActivityId(Integer activityID);

    public Appointment getAllByActivityIdAndUserId(Integer activityId,Integer userId);
}
