package com.tjCourse.softwareEngineering.backend.service.Implementation;

import com.tjCourse.softwareEngineering.backend.dao.repository.NormalAdminRepository;
import com.tjCourse.softwareEngineering.backend.dto.ReturnAdminInfoDTO;
import com.tjCourse.softwareEngineering.backend.entity.NormalAdmin;
import com.tjCourse.softwareEngineering.backend.service.NormalAdminService;
import com.tjCourse.softwareEngineering.common.service.implementation.CURDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NormalAdminServiceImpl extends CURDServiceImpl<NormalAdmin,Integer, NormalAdminRepository> implements NormalAdminService {
    @Autowired NormalAdminRepository normalAdminRepository;

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
    public Boolean checkAdmin(Integer ID, Integer status) {
        try {
            NormalAdmin normalAdmin = normalAdminRepository.getOne(ID);
            if (normalAdmin == null || normalAdmin.getStatus() != 1){
                return false;
            }

            if (status!=0 || status != 2){
                return false;
            }

            normalAdmin.setStatus(status);

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
}
