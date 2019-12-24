package com.tjCourse.softwareEngineering.backend.service;

import com.tjCourse.softwareEngineering.backend.pojo.ActivityDraft;
import com.tjCourse.softwareEngineering.common.service.CURDService;
import org.springframework.stereotype.Service;

@Service
public interface ActivityDraftService extends CURDService<ActivityDraft,Integer> {
}
