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
@Table(name = "normalAdmin")
public class NormalAdmin {
  @Id
  @Column(name = "ID")
  private int id;
  private int checkerId;
  private String name;
  private String password;
  private String emailAddress;
  private String phoneNumber;
  private String portrait;
  private String gender;
  private String organization;
  private int age;
  private int organizationId;
  private String reason;
  private String opinion;
  private int status;
}
