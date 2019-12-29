package com.tjCourse.softwareEngineering.backend.service.implementation;

import com.tjCourse.softwareEngineering.backend.dao.mapper.ActivityMapper;
import com.tjCourse.softwareEngineering.backend.dao.repository.ActivityRepository;
import com.tjCourse.softwareEngineering.backend.dto.ReturnBasicActivityInfoDTO;
import com.tjCourse.softwareEngineering.backend.entity.Activity;
import com.tjCourse.softwareEngineering.backend.service.ActivityService;
import com.tjCourse.softwareEngineering.common.service.implementation.CURDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl extends CURDServiceImpl<Activity,Integer, ActivityRepository> implements ActivityService{
//    @Autowired ActivityRepository activityRepository;
    @Autowired
    ActivityMapper activityMapper;

    @Override
    public List<ReturnBasicActivityInfoDTO> getActivitiesBasicInfo(String variety) {
        return activityMapper.getActivitiesBasicInfo(variety);
    }

    @Override
    public List<ReturnBasicActivityInfoDTO> getActivitiesBasicInfo_5(String variety){
        return activityMapper.getActivitiesBasicInfo_5(variety);
    }

    @Override
    public List<ReturnBasicActivityInfoDTO> getMyActivitiesBasicInfo(Integer userID){
        return activityMapper.getMyActivitiesBasicInfo(userID);
    }

}
