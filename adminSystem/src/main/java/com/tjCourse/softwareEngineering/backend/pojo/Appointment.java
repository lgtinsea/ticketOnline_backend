package com.tjCourse.softwareEngineering.backend.pojo;

import lombok.Data;

@Data
public class Appointment {

  private int userId;
  private int activityId;
  private int appointmentId;
  private int status;
}
