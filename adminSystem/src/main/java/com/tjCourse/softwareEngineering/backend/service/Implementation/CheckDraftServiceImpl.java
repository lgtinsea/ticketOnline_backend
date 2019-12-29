package com.tjCourse.softwareEngineering.backend.service.Implementation;

import com.tjCourse.softwareEngineering.backend.dao.repository.CheckDraftRepository;
import com.tjCourse.softwareEngineering.backend.entity.CheckDraft;
import com.tjCourse.softwareEngineering.backend.service.CheckDraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckDraftServiceImpl implements CheckDraftService {
    @Autowired
    CheckDraftRepository checkDraftRepository;


    @Override
    public List<CheckDraft> getByActivityDraftId(Integer draftID) {
        return checkDraftRepository.getByActivityDraftId(draftID);
    }
}
