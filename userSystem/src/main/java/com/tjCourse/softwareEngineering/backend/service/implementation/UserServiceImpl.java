package com.tjCourse.softwareEngineering.backend.service.implementation;

import com.tjCourse.softwareEngineering.backend.dao.repository.UserRepository;
import com.tjCourse.softwareEngineering.backend.dto.ReturnBasicInfoDTO;
import com.tjCourse.softwareEngineering.backend.pojo.User;
import com.tjCourse.softwareEngineering.backend.service.UserService;
import com.tjCourse.softwareEngineering.common.service.implementation.CURDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends CURDServiceImpl<User,Integer, UserRepository> implements UserService {
    @Autowired UserRepository repository;

    public ReturnBasicInfoDTO getBasicInfoById(Integer ID){
        return  repository.getBasicInfoById(ID);
    }
}
