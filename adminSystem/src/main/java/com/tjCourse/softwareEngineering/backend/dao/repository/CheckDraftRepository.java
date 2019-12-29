package com.tjCourse.softwareEngineering.backend.dao.repository;

import com.tjCourse.softwareEngineering.backend.entity.CheckDraft;
import com.tjCourse.softwareEngineering.backend.entity.CheckDraftPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheckDraftRepository extends JpaRepository<CheckDraft,CheckDraftPK> {
    public List<CheckDraft> getByActivityDraftId(Integer draftID);
}
