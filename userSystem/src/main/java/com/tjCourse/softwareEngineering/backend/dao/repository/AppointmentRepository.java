package com.tjCourse.softwareEngineering.backend.dao.repository;

import com.tjCourse.softwareEngineering.backend.pojo.Appointment;
import com.tjCourse.softwareEngineering.backend.pojo.AppointmentPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, AppointmentPK> {
}
