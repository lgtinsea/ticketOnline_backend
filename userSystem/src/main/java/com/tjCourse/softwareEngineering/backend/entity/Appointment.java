package com.tjCourse.softwareEngineering.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "appointment")
@IdClass(AppointmentPK.class)
public class Appointment {
  private int userId;
  @Id
  @Column(name = "activityID")
  private int activityId;
  @Id
  @Column(name = "appointmentID")
  private int appointmentId;
  private int status;
}
