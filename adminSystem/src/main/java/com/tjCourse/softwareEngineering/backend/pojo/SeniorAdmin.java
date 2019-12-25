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
@Table(name = "seniorAdmin")
public class SeniorAdmin {
  @Id
  @Column(name = "ID")
  private int id;
  private String name;
  private String password;
  private String emailAddress;
  private String phoneNumber;
  private String portrait;
  private String gender;
  private String organization;
  private int age;
  
}
