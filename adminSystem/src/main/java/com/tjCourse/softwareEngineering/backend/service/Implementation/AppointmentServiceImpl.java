package com.tjCourse.softwareEngineering.backend.service.Implementation;

import com.tjCourse.softwareEngineering.backend.dao.repository.AppointmentRepository;
import com.tjCourse.softwareEngineering.backend.pojo.Appointment;
import com.tjCourse.softwareEngineering.backend.pojo.AppointmentPK;
import com.tjCourse.softwareEngineering.backend.service.AppointmentService;
import com.tjCourse.softwareEngineering.common.service.implementation.CURDServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl extends CURDServiceImpl<Appointment, AppointmentPK, AppointmentRepository> implements AppointmentService {
}
