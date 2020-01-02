package com.tjCourse.softwareEngineering.backend.service.Implementation;

import com.tjCourse.softwareEngineering.backend.dao.repository.SeniorAdminRepository;
import com.tjCourse.softwareEngineering.backend.dto.ReturnAdminInfoDTO;
import com.tjCourse.softwareEngineering.backend.entity.SeniorAdmin;
import com.tjCourse.softwareEngineering.backend.service.EmailService;
import com.tjCourse.softwareEngineering.backend.service.SeniorAdminService;
import com.tjCourse.softwareEngineering.common.exception.ServiceException;
import com.tjCourse.softwareEngineering.common.service.implementation.CURDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SeniorAdminServiceImpl extends CURDServiceImpl<SeniorAdmin,Integer, SeniorAdminRepository> implements SeniorAdminService {
    @Autowired SeniorAdminRepository seniorAdminRepository;
    @Autowired
    EmailServiceImpl emailService;


    @Override
    public ReturnAdminInfoDTO getSeniorAdminInfo(Integer ID) {
        return seniorAdminRepository.getSeniorAdminInfo(ID);
    }

    @Override
    public SeniorAdmin getSeniorAdminByID(Integer ID) {
        return seniorAdminRepository.getOne(ID);
    }

    @Override
    public SeniorAdmin getSeniorAdminByEmail(String email) {
        return seniorAdminRepository.getByEmailAddress(email);
    }

    @Override
    public SeniorAdmin getSeniorAdminByEmailAndPassword(String email, String password) {
        return seniorAdminRepository.getByEmailAddressAndPassword(email,password);
    }

    @Override
    public String getVerifyCode(String id) {
        SeniorAdmin seniorAdmin = seniorAdminRepository.getByEmailAddress(id);
        Integer randomNum=new Random().nextInt(999999 - 100000 + 1) + 100000;
        String verifyCode= randomNum.toString();
        if(seniorAdmin != null) {// 注册请求但该账户已经注册
            throw new ServiceException("用户已注册", HttpStatus.CONFLICT);
        }
        emailService.sendReisterEmail(id,verifyCode);
        return verifyCode;
    }

}
