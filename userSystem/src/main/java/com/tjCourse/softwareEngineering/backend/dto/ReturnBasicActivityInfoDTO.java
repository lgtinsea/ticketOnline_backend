package com.tjCourse.softwareEngineering.backend.dto;

import cn.hutool.core.date.DateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class ReturnBasicActivityInfoDTO {
    private Integer ID;
    private String poster;
    private String name;
    private Timestamp time_start;
    private Timestamp time_end;
    private String address;
    private Integer click_num;
}
