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

//    @Autowired ActivityRepository activityRepository;

    @Override
    public List<ReturnBasicActivityInfoDTO> getActivitiesBasicInfo(String variety) {
        if (variety.equals("最新")){
            return activityMapper.getLatestActivitiesBasicInfo();
        }else if (variety.equals("最热")){
            return activityMapper.getHottestActivitiesBasicInfo();
        }
        return activityMapper.getActivitiesBasicInfo(variety);
    }

    @Override
    public List<ReturnBasicActivityInfoDTO> getActivitiesBasicInfo_limit(Integer limit, String variety){
        if (variety.equals("最新")){
            return activityMapper.getLatestActivitiesBasicInfo_limit(limit);
        }else if (variety.equals("最热")){
            return activityMapper.getHottestActivitiesBasicInfo_limit(limit);
        }
        return activityMapper.getActivitiesBasicInfo_limit(limit, variety);
    }

    @Override
    public List<ReturnBasicActivityInfoDTO> getMyActivitiesBasicInfo(Integer userID){
        return activityMapper.getMyActivitiesBasicInfo(userID);
    }

    @Override
    public Activity queryById(Integer id){
        Activity activity = activityMapper.getOne(id);
        int num = activity.getDay_click_num();
        activity.setDay_click_num(num + 1);
        activityMapper.updateClickNum(num+1,activity.getId());
        return activity;
    }

}
