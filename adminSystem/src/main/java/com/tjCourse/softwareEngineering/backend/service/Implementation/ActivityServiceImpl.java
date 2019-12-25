package com.tjCourse.softwareEngineering.backend.service.Implementation;

import com.tjCourse.softwareEngineering.backend.dao.repository.ActivityRepository;
import com.tjCourse.softwareEngineering.backend.pojo.Activity;
import com.tjCourse.softwareEngineering.backend.service.ActivityService;
import com.tjCourse.softwareEngineering.common.service.implementation.CURDServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl extends CURDServiceImpl<Activity,Integer, ActivityRepository> implements ActivityService {
}
