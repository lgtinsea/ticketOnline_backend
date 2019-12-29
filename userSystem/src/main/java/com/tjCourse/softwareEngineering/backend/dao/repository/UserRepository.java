package com.tjCourse.softwareEngineering.backend.dao.repository;

import com.tjCourse.softwareEngineering.backend.dto.ReturnBasicInfoDTO;
import com.tjCourse.softwareEngineering.backend.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value = "select new com.tjCourse.softwareEngineering.backend.dto.ReturnBasicInfoDTO(name,portrait) from User where id = ?1")
    public ReturnBasicInfoDTO getBasicInfoById(@Param("Id")Integer Id);
}
