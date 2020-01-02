package com.tjCourse.softwareEngineering.backend.service;

import com.tjCourse.softwareEngineering.backend.dto.ReturnAdminInfoDTO;
import com.tjCourse.softwareEngineering.backend.entity.NormalAdmin;
import com.tjCourse.softwareEngineering.common.service.CURDService;

import java.util.List;

public interface NormalAdminService extends CURDService<NormalAdmin,Integer> {
    Boolean applyForAdmin(String email_address, String reason);

    List<NormalAdmin> getUncheckedAdmin();

    Boolean checkAdmin(Integer seniorAdminID, Integer normalAdminID, Integer status);

    ReturnAdminInfoDTO getAdminOwnInfo(Integer ID);

    NormalAdmin getNormalAdminByID(Integer ID);

    NormalAdmin getNormalAdminByEmail(String email);

    NormalAdmin getNormalAdminByEmailAndPassword(String email,String password);

    String getVerifyCode(String id);
}
