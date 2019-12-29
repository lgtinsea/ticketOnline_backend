package com.tjCourse.softwareEngineering.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnActivitiesCoverDTO {
    private Integer ID;
    private String name;
    private String poster;
}
