package com.tjCourse.softwareEngineering.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnDraftDTO {
    private Integer draftID;
    private Integer activityID;
    private String name;
    private Integer status;
}
