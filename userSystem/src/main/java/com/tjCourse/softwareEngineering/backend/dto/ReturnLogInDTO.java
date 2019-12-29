package com.tjCourse.softwareEngineering.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReturnLogInDTO {
    private Boolean ifSuccessful;
    private Integer userID;
    private Integer accountType;
}
