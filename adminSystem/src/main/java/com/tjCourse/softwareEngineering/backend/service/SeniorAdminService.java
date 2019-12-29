package com.tjCourse.softwareEngineering.backend.service;

import com.tjCourse.softwareEngineering.backend.dto.ReturnAdminInfoDTO;
import com.tjCourse.softwareEngineering.backend.entity.SeniorAdmin;
import com.tjCourse.softwareEngineering.common.service.CURDService;

public interface SeniorAdminService extends CURDService<SeniorAdmin,Integer> {
    public ReturnAdminInfoDTO getSeniorAdminInfo(Integer ID);
}
