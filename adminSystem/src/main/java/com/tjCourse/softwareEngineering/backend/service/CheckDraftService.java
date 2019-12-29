package com.tjCourse.softwareEngineering.backend.service;

import com.tjCourse.softwareEngineering.backend.entity.CheckDraft;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CheckDraftService {
    public List<CheckDraft> getByActivityDraftId(Integer draftID);
}
