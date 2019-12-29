package com.tjCourse.softwareEngineering.backend.service.Implementation;

import com.tjCourse.softwareEngineering.backend.dao.repository.ActivityDraftRepository;
import com.tjCourse.softwareEngineering.backend.dao.repository.ActivityRepository;
import com.tjCourse.softwareEngineering.backend.dao.repository.NormalAdminRepository;
import com.tjCourse.softwareEngineering.backend.dto.ReturnDraftDTO;
import com.tjCourse.softwareEngineering.backend.entity.ActivityDraft;
import com.tjCourse.softwareEngineering.backend.service.ActivityDraftService;
import com.tjCourse.softwareEngineering.common.service.implementation.CURDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityDraftServiceImpl extends CURDServiceImpl<ActivityDraft,Integer, ActivityDraftRepository> implements ActivityDraftService {
    @Autowired
    ActivityDraftRepository activityDraftRepository;
    @Autowired
    NormalAdminRepository normalAdminRepository;

    @Override
    public List<ReturnDraftDTO> getUncheckedDraft(Integer adminID, Integer role) {
        if (role.equals(1)){
            return activityDraftRepository.getDepartDraftInfo(normalAdminRepository.getById(adminID).getOrganizationId());
        }else if (role.equals(2)){
            return activityDraftRepository.getAllDraftInfo();
        }else {
            return null;
        }
    }

    @Override
    public List<ReturnDraftDTO> getEditDraft() {
        return activityDraftRepository.getDraftInfoByStatus(0);
    }
}
