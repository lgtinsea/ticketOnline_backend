package com.tjCourse.softwareEngineering.backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReturnReportDTOHead {
    private Integer activity_ID;
    private String name;
    private Integer sum;
}
