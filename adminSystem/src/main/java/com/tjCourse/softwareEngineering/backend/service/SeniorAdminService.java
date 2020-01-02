package com.tjCourse.softwareEngineering.backend.service;

import com.tjCourse.softwareEngineering.backend.dto.ReturnAdminInfoDTO;
import com.tjCourse.softwareEngineering.backend.entity.NormalAdmin;
import com.tjCourse.softwareEngineering.backend.entity.SeniorAdmin;
import com.tjCourse.softwareEngineering.common.service.CURDService;

public interface SeniorAdminService extends CURDService<SeniorAdmin,Integer> {
    ReturnAdminInfoDTO getSeniorAdminInfo(Integer ID);

    SeniorAdmin getSeniorAdminByID(Integer ID);

    SeniorAdmin getSeniorAdminByEmail(String email);

    SeniorAdmin getSeniorAdminByEmailAndPassword(String email,String password);

    String getVerifyCode(String id);
}
