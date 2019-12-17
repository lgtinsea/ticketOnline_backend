package com.tjCourse.softwareEngineering.pojo;

import lombok.Data;

@Data
public class NormalAdmin {

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
