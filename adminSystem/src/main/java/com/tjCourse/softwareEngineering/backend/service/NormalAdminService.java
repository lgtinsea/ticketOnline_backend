package com.tjCourse.softwareEngineering.backend.service;

import com.tjCourse.softwareEngineering.backend.dto.ReturnAdminInfoDTO;
import com.tjCourse.softwareEngineering.backend.entity.NormalAdmin;
import com.tjCourse.softwareEngineering.common.service.CURDService;

import java.util.List;

public interface NormalAdminService extends CURDService<NormalAdmin,Integer> {
    public Boolean applyForAdmin(String email_address,String reason);

    public List<NormalAdmin> getUncheckedAdmin();

    public Boolean checkAdmin(Integer seniorAdminID, Integer normalAdminID ,Integer status);

    public ReturnAdminInfoDTO getAdminOwnInfo(Integer ID);
}
