package com.tjCourse.softwareEngineering.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "activity")
public class Activity {
  @Id
  @Column(name = "ID")
  private int id;
  private int seniorAdminId;
  private java.sql.Timestamp time;
  private String name;
  private String introduction;
  private String address;
  private String sponsor;
  private String poster;
  @Column(name = "content",columnDefinition = "text")
  private String content;
  private int peopleAmount;
  private int type;
  private java.sql.Timestamp releaseTime;
  private int organizationId;

}
