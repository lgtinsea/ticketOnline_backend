package com.tjCourse.softwareEngineering.backend.service;

import com.tjCourse.softwareEngineering.backend.dto.ReturnBasicInfoDTO;
import com.tjCourse.softwareEngineering.backend.entity.User;
import com.tjCourse.softwareEngineering.common.service.CURDService;

public interface UserService extends CURDService<User,Integer> {
    public ReturnBasicInfoDTO getBasicInfoById(Integer ID);
}
