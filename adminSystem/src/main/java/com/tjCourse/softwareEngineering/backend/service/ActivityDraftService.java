package com.tjCourse.softwareEngineering.backend.service;

import com.tjCourse.softwareEngineering.backend.dto.ReturnDraftDTO;
import com.tjCourse.softwareEngineering.backend.entity.ActivityDraft;
import com.tjCourse.softwareEngineering.common.service.CURDService;

import java.util.List;

public interface ActivityDraftService extends CURDService<ActivityDraft,Integer> {

    public List<ReturnDraftDTO> getUncheckedDraft(Integer adminID,Integer role);

    public List<ReturnDraftDTO> getEditDraft();
}
