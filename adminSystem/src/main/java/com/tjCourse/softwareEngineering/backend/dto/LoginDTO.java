package com.tjCourse.softwareEngineering.backend.dto;

import com.tjCourse.softwareEngineering.backend.entity.NormalAdmin;
import com.tjCourse.softwareEngineering.backend.entity.SeniorAdmin;
import lombok.Data;

@Data
public class LoginDTO {
    private Integer id;

    private String name;

    private String email;

    private String portrait;

    private String role;

    private String Authorization;

    public LoginDTO(NormalAdmin normalAdmin){
        this.id = normalAdmin.getId();
        this.name = normalAdmin.getName();
        this.email = normalAdmin.getEmailAddress();
        this.portrait = normalAdmin.getPortrait();
        this.role = "normalAdmin";
    }

    public LoginDTO(SeniorAdmin seniorAdmin){
        this.id = seniorAdmin.getId();
        this.name = seniorAdmin.getName();
        this.email = seniorAdmin.getEmailAddress();
        this.portrait = seniorAdmin.getPortrait();
        this.role = "seniorAdmin";
    }
}
