package com.tjCourse.softwareEngineering.backend.service.Implementation;

import com.tjCourse.softwareEngineering.backend.dao.repository.ActivityDraftRepository;
import com.tjCourse.softwareEngineering.backend.pojo.ActivityDraft;
import com.tjCourse.softwareEngineering.backend.service.ActivityDraftService;
import com.tjCourse.softwareEngineering.common.service.implementation.CURDServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ActivityDraftServiceImpl extends CURDServiceImpl<ActivityDraft,Integer, ActivityDraftRepository> implements ActivityDraftService {
}
