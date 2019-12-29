package com.tjCourse.softwareEngineering.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnActivityReportDTO {
    private Integer activityID;
    private Integer real_num;
    private Integer sum;
    private String name;
}
