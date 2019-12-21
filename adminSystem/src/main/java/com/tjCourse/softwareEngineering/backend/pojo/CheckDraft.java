package com.tjCourse.softwareEngineering.backend.pojo;

import lombok.Data;

@Data
public class CheckDraft {

  private int seniorAdminId;
  private int activityDraftId;
  private int checkNumber;
  private String opinion;
  private int result;
  private java.sql.Timestamp checkTime;
  
}
