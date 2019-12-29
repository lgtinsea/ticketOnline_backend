package com.tjCourse.softwareEngineering.backend.dao.repository;

import com.tjCourse.softwareEngineering.backend.dto.ReturnDraftDTO;
import com.tjCourse.softwareEngineering.backend.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity,Integer> {

}
