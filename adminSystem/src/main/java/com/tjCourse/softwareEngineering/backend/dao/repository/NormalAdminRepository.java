package com.tjCourse.softwareEngineering.backend.dao.repository;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.tjCourse.softwareEngineering.backend.dto.ReturnAdminInfoDTO;
import com.tjCourse.softwareEngineering.backend.entity.NormalAdmin;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NormalAdminRepository extends JpaRepository<NormalAdmin,Integer> {
    NormalAdmin getByEmailAddress(String emailAddress);

    List<NormalAdmin> getByStatus(Integer status);

    NormalAdmin getById(Integer ID);

    NormalAdmin getByEmailAddressAndPassword(String emailAddress,String password);

    @Query(value = "select new com.tjCourse.softwareEngineering.backend.dto.ReturnAdminInfoDTO(portrait,name) from NormalAdmin where ID = :ID")
    ReturnAdminInfoDTO getAdminInfo(@Param("ID") Integer ID);
}
