package com.tjCourse.softwareEngineering.backend.pojo;

import lombok.Data;

@Data
public class Comment {

  private int id;
  private int userId;
  private int activityId;
  private int adminId;
  private String content;
  private java.sql.Timestamp time;
  private int ifAppeared;
  private int replyId;

}
