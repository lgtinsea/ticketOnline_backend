package com.tjCourse.softwareEngineering.backend.pojo;

import lombok.Data;

@Data
public class Organization {

  private int id;
  private String name;
  private int type;
  private int seniorOrganization;
  private int adminNumber;

}
