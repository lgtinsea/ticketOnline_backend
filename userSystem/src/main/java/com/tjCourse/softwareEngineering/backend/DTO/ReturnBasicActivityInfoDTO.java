package com.tjCourse.softwareEngineering.backend.DTO;

import cn.hutool.core.date.DateTime;
import lombok.Data;

@Data
public class ReturnBasicActivityInfoDTO {
    private Integer ID;
    private String poster;
    private String name;
    private DateTime time;
    private String address;
}
