package com.tjCourse.softwareEngineering.backend.service;

import com.tjCourse.softwareEngineering.backend.pojo.Appointment;
import com.tjCourse.softwareEngineering.common.service.CURDService;
import org.springframework.stereotype.Service;

@Service
public interface AppointmentService extends CURDService<Appointment,Integer> {
}
