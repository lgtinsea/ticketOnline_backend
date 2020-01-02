package com.tjCourse.softwareEngineering.backend.service;

import com.tjCourse.softwareEngineering.backend.dto.ReturnBasicInfoDTO;
import com.tjCourse.softwareEngineering.backend.entity.User;
import com.tjCourse.softwareEngineering.common.service.CURDService;

public interface UserService extends CURDService<User,Integer> {
    ReturnBasicInfoDTO getBasicInfoById(Integer ID);

    User getUserByEmail(String email);

    User getUserByEmailAndPassword(String email,String password);

    String getVerifyCode(String id);
}
