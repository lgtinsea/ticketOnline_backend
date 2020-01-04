package com.tjCourse.softwareEngineering.backend.dao.mapper;

import com.tjCourse.softwareEngineering.backend.dto.ReturnBasicActivityInfoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityMapper {
    public List<ReturnBasicActivityInfoDTO> getActivitiesBasicInfo(String variety);

    public List<ReturnBasicActivityInfoDTO> getActivitiesBasicInfo_limit(@Param("limit")Integer limit, @Param("variety") String variety);

    public List<ReturnBasicActivityInfoDTO> getMyActivitiesBasicInfo(Integer userID);

    public List<ReturnBasicActivityInfoDTO> getLatestActivitiesBasicInfo();

    public List<ReturnBasicActivityInfoDTO> getLatestActivitiesBasicInfo_limit(Integer limit);

}
