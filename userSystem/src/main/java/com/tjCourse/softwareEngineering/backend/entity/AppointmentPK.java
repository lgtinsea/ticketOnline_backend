package com.tjCourse.softwareEngineering.backend.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class AppointmentPK implements Serializable {
    private Integer appointmentId;
    private Integer activityId;
}
