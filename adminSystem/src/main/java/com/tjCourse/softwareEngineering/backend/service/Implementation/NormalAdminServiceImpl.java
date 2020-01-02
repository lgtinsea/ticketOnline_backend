package com.tjCourse.softwareEngineering.backend.service.Implementation;

import com.tjCourse.softwareEngineering.backend.dao.repository.NormalAdminRepository;
import com.tjCourse.softwareEngineering.backend.dto.ReturnAdminInfoDTO;
import com.tjCourse.softwareEngineering.backend.entity.NormalAdmin;
import com.tjCourse.softwareEngineering.backend.entity.User;
import com.tjCourse.softwareEngineering.backend.service.EmailService;
import com.tjCourse.softwareEngineering.backend.service.NormalAdminService;
import com.tjCourse.softwareEngineering.common.exception.ServiceException;
import com.tjCourse.softwareEngineering.common.service.implementation.CURDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class NormalAdminServiceImpl extends CURDServiceImpl<NormalAdmin,Integer, NormalAdminRepository> implements NormalAdminService {
    @Autowired NormalAdminRepository normalAdminRepository;
    @Autowired
    EmailServiceImpl emailService;

    @Override
    public Boolean applyForAdmin(String email_address, String reason) {
        try {
            NormalAdmin normalAdmin = normalAdminRepository.getByEmailAddress(email_address);
            if (normalAdmin==null || normalAdmin.getStatus() != 0){
                return false;
            }

            normalAdmin.setReason(reason);
            normalAdmin.setStatus(1);

            normalAdminRepository.saveAndFlush(normalAdmin);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<NormalAdmin> getUncheckedAdmin() {
        return normalAdminRepository.getByStatus(1);
    }

    @Override
    public Boolean checkAdmin(Integer seniorAdminID,Integer normalAdminID, Integer status) {
        try {
            NormalAdmin normalAdmin = normalAdminRepository.getOne(normalAdminID);
            if (normalAdmin == null || normalAdmin.getStatus() != 1){
                return false;
            }

            if (status!=0 || status != 2){
                return false;
            }

            normalAdmin.setStatus(status);
            normalAdmin.setCheckerId(seniorAdminID);

            normalAdminRepository.saveAndFlush(normalAdmin);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ReturnAdminInfoDTO getAdminOwnInfo(Integer ID) {
        return normalAdminRepository.getAdminInfo(ID);
    }

    @Override
    public NormalAdmin getNormalAdminByID(Integer ID) {
        return normalAdminRepository.getById(ID);
    }

    @Override
    public NormalAdmin getNormalAdminByEmail(String email) {
        return normalAdminRepository.getByEmailAddress(email);
    }

    @Override
    public NormalAdmin getNormalAdminByEmailAndPassword(String email, String password) {
        return normalAdminRepository.getByEmailAddressAndPassword(email,password);
    }

    @Override
    public String getVerifyCode(String id) {
        NormalAdmin normalAdmin = normalAdminRepository.getByEmailAddress(id);
        Integer randomNum=new Random().nextInt(999999 - 100000 + 1) + 100000;
        String verifyCode= randomNum.toString();
        if(normalAdmin != null) {// 注册请求但该账户已经注册
            throw new ServiceException("用户已注册", HttpStatus.CONFLICT);
        }
        emailService.sendReisterEmail(id,verifyCode);
        return verifyCode;
    }

}
