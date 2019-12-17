package com.tjCourse.softwareEngineering.pojo;

import lombok.Data;

@Data
public class ActivityDraft {

  private int id;
  private int normalAdminId;
  private java.sql.Timestamp time;
  private String name;
  private String introduction;
  private String address;
  private String sponsor;
  private String poster;
  private String content;
  private int peopleAmount;
  private int status;
  private int activityId;
  private java.sql.Timestamp applyTime;
  private int type;
  private int organizationId;

}
