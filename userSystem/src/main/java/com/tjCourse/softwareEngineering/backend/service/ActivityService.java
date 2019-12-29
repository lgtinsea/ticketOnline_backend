package com.tjCourse.softwareEngineering.backend.service;

import com.tjCourse.softwareEngineering.backend.dto.ReturnBasicActivityInfoDTO;
import com.tjCourse.softwareEngineering.backend.pojo.Activity;
import com.tjCourse.softwareEngineering.common.service.CURDService;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ActivityService extends CURDService<Activity,Integer> {
    public List<ReturnBasicActivityInfoDTO> getActivitiesBasicInfo(String variety);

    public List<ReturnBasicActivityInfoDTO> getActivitiesBasicInfo_5(String variety);

    public List<ReturnBasicActivityInfoDTO> getMyActivitiesBasicInfo(Integer userID);
}
