package com.tjCourse.softwareEngineering.backend.dto;

import com.tjCourse.softwareEngineering.backend.entity.User;
import lombok.Data;

@Data
public class LoginDTO {
    private String name;

    private String email;

    private String portrait;

    private String role;

    private String Authorization;

    public LoginDTO(User user){
        this.name = user.getName();
        this.email = user.getEmailAddress();
        this.portrait = user.getPortrait();
        this.role = "user";
    }
}
