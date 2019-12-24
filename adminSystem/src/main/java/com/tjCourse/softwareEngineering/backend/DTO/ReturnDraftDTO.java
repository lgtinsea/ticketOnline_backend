package com.tjCourse.softwareEngineering.backend.DTO;

import lombok.Data;

@Data
public class ReturnDraftDTO {
    private Integer draftID;
    private Integer activityID;
    private String name;
    private Integer status;
}
