package com.tjCourse.softwareEngineering.backend.service.implementation;

import com.tjCourse.softwareEngineering.backend.dao.repository.UserRepository;
import com.tjCourse.softwareEngineering.backend.dto.ReturnBasicInfoDTO;
import com.tjCourse.softwareEngineering.backend.entity.User;
import com.tjCourse.softwareEngineering.backend.service.UserService;
import com.tjCourse.softwareEngineering.common.exception.ServiceException;
import com.tjCourse.softwareEngineering.common.service.implementation.CURDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class UserServiceImpl extends CURDServiceImpl<User,Integer, UserRepository> implements UserService {
    @Autowired UserRepository repository;
    @Autowired EmailServiceImpl emailService;

    public ReturnBasicInfoDTO getBasicInfoById(Integer ID){
        return  repository.getBasicInfoById(ID);
    }

    public User getUserByEmail(String email){
        return repository.getByEmailAddress(email);
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        return repository.getByEmailAddressAndPassword(email,password);
    }

    @Override
    public String getVerifyCode(String id) {
        User user = repository.getByEmailAddress(id);
        Integer randomNum=new Random().nextInt(999999 - 100000 + 1) + 100000;
        String verifyCode= randomNum.toString();
        if(user != null) {// 注册请求但该账户已经注册
                throw new ServiceException("用户已注册", HttpStatus.CONFLICT);
            }
        emailService.sendReisterEmail(id,verifyCode);
        return verifyCode;
    }
}
