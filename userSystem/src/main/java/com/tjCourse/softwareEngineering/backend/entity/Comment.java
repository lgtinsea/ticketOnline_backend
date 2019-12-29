package com.tjCourse.softwareEngineering.backend.entity;

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
@Table(name = "comment")
public class Comment {
  @Id
  @Column(name = "ID")
  private int id;
  private int userId;
  private int activityId;
  private int adminId;
  private String content;
  private java.sql.Timestamp time;
  private Boolean ifAppeared;
  private int replyId;

}
