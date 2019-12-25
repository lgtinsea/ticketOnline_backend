package com.tjCourse.softwareEngineering.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "organization")
public class Organization {
  @Id
  @Column(name = "ID")
  private int id;
  private String name;
  private int type;
  private int seniorOrganization;
  private int adminNumber;
  
}
