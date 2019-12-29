package com.tjCourse.softwareEngineering.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "checkDraft")
@IdClass(CheckDraftPK.class)
public class CheckDraft {
  @Id
  @Column(name = "seniorAdminID")
  private int seniorAdminId;
  @Id
  @Column(name = "activityDraftID")
  private int activityDraftId;
  private int checkNumber;
  private String opinion;
  private int result;
  private java.sql.Timestamp checkTime;
  
}
