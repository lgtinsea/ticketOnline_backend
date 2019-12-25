package com.tjCourse.softwareEngineering.backend.dao.repository;

import com.tjCourse.softwareEngineering.backend.pojo.CheckDraft;
import com.tjCourse.softwareEngineering.backend.pojo.CheckDraftPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CheckDraftRepository extends JpaRepository<CheckDraft,CheckDraftPK> {
}
