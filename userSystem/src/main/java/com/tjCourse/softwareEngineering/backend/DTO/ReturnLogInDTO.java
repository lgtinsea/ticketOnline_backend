package com.tjCourse.softwareEngineering.backend.DTO;

import lombok.Data;

@Data
public class ReturnLogInDTO {
    private Boolean ifSuccessful;
    private Integer userID;
    private Integer accountType;
}
