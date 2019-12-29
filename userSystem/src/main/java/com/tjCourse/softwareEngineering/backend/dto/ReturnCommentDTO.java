package com.tjCourse.softwareEngineering.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class ReturnCommentDTO {
    private Integer ID;
    private Integer replyID;
    private String name;
    private String portrait;
    private String content;
    private Timestamp time;
}
