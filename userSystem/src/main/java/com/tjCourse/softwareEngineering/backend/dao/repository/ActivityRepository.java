package com.tjCourse.softwareEngineering.backend.dao.repository;

import com.tjCourse.softwareEngineering.backend.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity,Integer> {
/*
    @Query(value = "select new com.tjCourse.softwareEngineering.backend.dto.ReturnBasicActivityInfoDTO(ID,poster,name,time,address) from Activity where type = :variety")
    public List<ReturnBasicActivityInfoDTO> getActivitiesBasicInfo(String variety);
*/

/*
    @Query(value = "select new com.tjCourse.softwareEngineering.backend.dto.ReturnBasicActivityInfoDTO(ID,poster,name,time,address) from Activity where type = :variety limit 5")
    public List<ReturnBasicActivityInfoDTO> getActivitiesBasicInfo_5(String variety);
*/
}
