package com.tjCourse.softwareEngineering.backend.dao.mapper;

import com.tjCourse.softwareEngineering.backend.dto.ReturnActivitiesCoverDTO;
import com.tjCourse.softwareEngineering.backend.dto.ReturnActivitiesDTO;
import com.tjCourse.softwareEngineering.backend.pojo.ReturnReportDTOHead;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityMapper {
    public List<ReturnActivitiesDTO> getActivityInfo();

    public List<ReturnActivitiesDTO> getDepartActivityInfo(Integer organization_ID);

    public List<ReturnActivitiesCoverDTO> getActivityCover();

    public List<ReturnActivitiesCoverDTO> getDepartActivityCover(Integer organization_ID);

    public List<ReturnReportDTOHead> getActivityReportHead();
}
