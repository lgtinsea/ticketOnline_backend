package com.tjCourse.softwareEngineering.backend.service.implementation;

import com.tjCourse.softwareEngineering.backend.dao.repository.AppointmentRepository;
import com.tjCourse.softwareEngineering.backend.pojo.Appointment;
import com.tjCourse.softwareEngineering.backend.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;

    public Integer countByActivityId(Integer activityID){
        return appointmentRepository.countByActivityId(activityID);
    }

    @Override
    public Boolean addAppointment(Integer user_ID, Integer activity_ID){
        try {
            Appointment appointment = new Appointment();
            appointment.setActivityId(activity_ID);
            appointment.setUserId(user_ID);
            appointment.setStatus(1);

            appointmentRepository.save(appointment);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean deleteAppointment(Integer user_ID,Integer activity_ID){
        try {
            Appointment appointment = appointmentRepository.getAllByActivityIdAndUserId(activity_ID,user_ID);
            if (appointment==null){
                return false;
            }

            if (appointment.getStatus() == 1) {
                appointment.setStatus(0);
            }else {
                return false;
            }
            appointmentRepository.saveAndFlush(appointment);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
