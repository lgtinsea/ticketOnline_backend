package com.tjCourse.softwareEngineering.backend.service;

import com.tjCourse.softwareEngineering.backend.dto.ReturnActivitiesCoverDTO;
import com.tjCourse.softwareEngineering.backend.dto.ReturnActivitiesDTO;
import com.tjCourse.softwareEngineering.backend.dto.ReturnActivityReportDTO;
import com.tjCourse.softwareEngineering.backend.entity.Activity;
import com.tjCourse.softwareEngineering.common.service.CURDService;

import java.util.List;

public interface ActivityService extends CURDService<Activity,Integer> {
    public List<ReturnActivitiesDTO> getActivityInfo(Integer admin_ID, Integer role);

    public List<ReturnActivitiesCoverDTO> getActivityCover(Integer admin_ID,Integer role);

    public List<ReturnActivityReportDTO> getActivityReport();

    public Boolean updateActivity(Activity activity);

    public Boolean checkActivity(Integer draftID,Integer adminID,String opinion,Integer result);
}
