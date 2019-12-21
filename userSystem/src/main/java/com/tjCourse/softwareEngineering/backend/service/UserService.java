package com.tjCourse.softwareEngineering.backend.service;

import com.tjCourse.softwareEngineering.backend.pojo.User;
import com.tjCourse.softwareEngineering.common.service.CURDService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends CURDService<User,Integer> {

}
