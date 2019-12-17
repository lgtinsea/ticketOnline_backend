package com.tjCourse.softwareEngineering.pojo;

import lombok.Data;

@Data
public class Activity {

  private int id;
  private int seniorAdminId;
  private java.sql.Timestamp time;
  private String name;
  private String introduction;
  private String address;
  private String sponsor;
  private String poster;
  private String content;
  private int peopleAmount;
  private int type;
  private java.sql.Timestamp releaseTime;
  private int organizationId;

}
