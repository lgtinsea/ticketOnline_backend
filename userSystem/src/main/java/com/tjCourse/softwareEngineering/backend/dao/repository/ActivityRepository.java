package com.tjCourse.softwareEngineering.backend.dao.repository;

import com.tjCourse.softwareEngineering.backend.dto.ReturnBasicActivityInfoDTO;
import com.tjCourse.softwareEngineering.backend.pojo.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity,Integer> {
    @Query(value = "select ID,poster,name,time,address from Activity where type = :variety",nativeQuery = true)
    public List<ReturnBasicActivityInfoDTO> getActivitiesBasicInfo(String variety);

    @Query(value = "select ID,poster,name,time,address from Activity where type = :variety limit 5",nativeQuery = true)
    public List<ReturnBasicActivityInfoDTO> getActivitiesBasicInfo_5(String variety);
}
