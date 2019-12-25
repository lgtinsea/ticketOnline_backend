package com.tjCourse.softwareEngineering.backend.service.Implementation;

import com.tjCourse.softwareEngineering.backend.dao.repository.NormalAdminRepository;
import com.tjCourse.softwareEngineering.backend.pojo.NormalAdmin;
import com.tjCourse.softwareEngineering.backend.service.NormalAdminService;
import com.tjCourse.softwareEngineering.common.service.implementation.CURDServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class NormalAdminServiceImpl extends CURDServiceImpl<NormalAdmin,Integer, NormalAdminRepository> implements NormalAdminService {
}
