package com.tjCourse.softwareEngineering.backend.dao.repository;

import com.tjCourse.softwareEngineering.backend.dto.ReturnAdminInfoDTO;
import com.tjCourse.softwareEngineering.backend.entity.SeniorAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SeniorAdminRepository extends JpaRepository<SeniorAdmin,Integer> {
    @Query(value = "select new com.tjCourse.softwareEngineering.backend.dto.ReturnAdminInfoDTO(portrait,name) from SeniorAdmin where ID = :ID")
    public ReturnAdminInfoDTO getSeniorAdminInfo(Integer ID);

    SeniorAdmin getByEmailAddress(String email);

    SeniorAdmin getByEmailAddressAndPassword(String emailAddress, String password);
}
