package com.tjCourse.softwareEngineering.backend.service;

import com.tjCourse.softwareEngineering.backend.pojo.SeniorAdmin;
import com.tjCourse.softwareEngineering.common.service.CURDService;
import org.springframework.stereotype.Service;

@Service
public interface SeniorAdminService extends CURDService<SeniorAdmin,Integer> {
}
