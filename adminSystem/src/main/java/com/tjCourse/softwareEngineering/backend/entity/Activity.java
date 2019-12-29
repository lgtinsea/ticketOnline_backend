package com.tjCourse.softwareEngineering.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "activity")
public class Activity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private int id;

  private int seniorAdminId;
  private java.sql.Timestamp time_start;
  private Timestamp time_end;
  private String name;
  private String introduction;
  private String address;
  private String sponsor;
  private String poster;
  @Column(name = "content",columnDefinition = "text")
  private String content;
  private int peopleAmount;
  private String type;
  private java.sql.Timestamp releaseTime;
  private int organizationId;

  public Activity(ActivityDraft activityDraft){
    this.time_start = activityDraft.getTime_start();
    this.time_end = activityDraft.getTime_end();
    this.name = activityDraft.getName();
    this.introduction = activityDraft.getIntroduction();
    this.address = activityDraft.getAddress();
    this.sponsor = activityDraft.getSponsor();
    this.poster = activityDraft.getPoster();
    this.content = activityDraft.getContent();
    this.peopleAmount = activityDraft.getPeopleAmount();
    this.type = activityDraft.getType();
    this.organizationId = activityDraft.getOrganizationId();
  }
}
