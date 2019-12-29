package com.tjCourse.softwareEngineering.backend.dao.repository;

import com.tjCourse.softwareEngineering.backend.dto.ReturnAdminInfoDTO;
import com.tjCourse.softwareEngineering.backend.entity.NormalAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NormalAdminRepository extends JpaRepository<NormalAdmin,Integer> {
    public NormalAdmin getByEmailAddress(String emailAddress);

    public List<NormalAdmin> getByStatus(Integer status);

    public NormalAdmin getById(Integer ID);

    @Query(value = "select new com.tjCourse.softwareEngineering.backend.dto.ReturnAdminInfoDTO(portrait,name) from normalAdmin where ID = :ID")
    public ReturnAdminInfoDTO getAdminInfo(Integer ID);
}
