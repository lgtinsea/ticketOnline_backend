package com.tjCourse.softwareEngineering.backend.pojo;

import lombok.Data;

@Data
public class User {

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
