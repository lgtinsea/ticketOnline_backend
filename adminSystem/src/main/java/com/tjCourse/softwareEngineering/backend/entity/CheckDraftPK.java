package com.tjCourse.softwareEngineering.backend.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class CheckDraftPK implements Serializable {
    private int seniorAdminId;
    private int activityDraftId;
}
