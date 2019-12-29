package com.tjCourse.softwareEngineering.backend.dao.mapper;

import com.tjCourse.softwareEngineering.backend.dto.ReturnBasicActivityInfoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityMapper {
    public List<ReturnBasicActivityInfoDTO> getActivitiesBasicInfo(String variety);

    public List<ReturnBasicActivityInfoDTO> getActivitiesBasicInfo_5(String variety);

    public List<ReturnBasicActivityInfoDTO> getMyActivitiesBasicInfo(Integer userID);
}
