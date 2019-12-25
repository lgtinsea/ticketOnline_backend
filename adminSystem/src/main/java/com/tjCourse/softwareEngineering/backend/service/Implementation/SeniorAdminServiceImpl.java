package com.tjCourse.softwareEngineering.backend.service.Implementation;

import com.tjCourse.softwareEngineering.backend.dao.repository.SeniorAdminRepository;
import com.tjCourse.softwareEngineering.backend.pojo.SeniorAdmin;
import com.tjCourse.softwareEngineering.backend.service.SeniorAdminService;
import com.tjCourse.softwareEngineering.common.service.implementation.CURDServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SeniorAdminServiceImpl extends CURDServiceImpl<SeniorAdmin,Integer, SeniorAdminRepository> implements SeniorAdminService {
}
