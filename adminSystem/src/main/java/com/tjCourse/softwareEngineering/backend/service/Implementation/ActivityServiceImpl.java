package com.tjCourse.softwareEngineering.backend.service.Implementation;

import com.tjCourse.softwareEngineering.backend.dao.mapper.ActivityMapper;
import com.tjCourse.softwareEngineering.backend.dao.repository.*;
import com.tjCourse.softwareEngineering.backend.dto.ReturnActivitiesCoverDTO;
import com.tjCourse.softwareEngineering.backend.dto.ReturnActivitiesDTO;
import com.tjCourse.softwareEngineering.backend.dto.ReturnActivityReportDTO;
import com.tjCourse.softwareEngineering.backend.entity.Activity;
import com.tjCourse.softwareEngineering.backend.entity.ActivityDraft;
import com.tjCourse.softwareEngineering.backend.entity.CheckDraft;
import com.tjCourse.softwareEngineering.backend.entity.NormalAdmin;
import com.tjCourse.softwareEngineering.backend.pojo.ReturnReportDTOHead;
import com.tjCourse.softwareEngineering.backend.service.ActivityService;
import com.tjCourse.softwareEngineering.common.service.implementation.CURDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityServiceImpl extends CURDServiceImpl<Activity,Integer, ActivityRepository> implements ActivityService {
    @Autowired ActivityRepository activityRepository;
    @Autowired
    ActivityMapper activityMapper;
    @Autowired
    NormalAdminRepository normalAdminRepository;
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    ActivityDraftRepository activityDraftRepository;
    @Autowired
    CheckDraftRepository checkDraftRepository;

    @Override
    public List<ReturnActivitiesDTO> getActivityInfo(Integer admin_ID, Integer role) {
        if (role.equals(1)) {
            NormalAdmin normalAdmin = normalAdminRepository.getById(admin_ID);
            return activityMapper.getDepartActivityInfo(normalAdmin.getOrganizationId());
        }else if (role.equals(2)){
            return activityMapper.getActivityInfo();
        }else {
            return null;
        }
    }

    @Override
    public List<ReturnActivitiesCoverDTO> getActivityCover(Integer admin_ID, Integer role) {
        if(role.equals(1)){
            NormalAdmin normalAdmin = normalAdminRepository.getById(admin_ID);
            return activityMapper.getDepartActivityCover(normalAdmin.getOrganizationId());
        }else if (role.equals(2)){
            return activityMapper.getActivityCover();
        }else {
            return null;
        }
    }

    @Override
    public List<ReturnActivityReportDTO> getActivityReport() {
        List<ReturnActivityReportDTO> list_report = new ArrayList<>();

        List<ReturnReportDTOHead> list_head = activityMapper.getActivityReportHead();
        for (ReturnReportDTOHead h : list_head){
            ReturnActivityReportDTO reportDTO = new ReturnActivityReportDTO();
            reportDTO.setActivityID(h.getActivity_ID());
            reportDTO.setName(h.getName());
            reportDTO.setSum(h.getSum());
            reportDTO.setReal_num(appointmentRepository.countByActivityId(h.getActivity_ID()));
            list_report.add(reportDTO);
        }
        return list_report;
    }

    @Override
    public Boolean updateActivity(Activity activity) {
        try {
            activityRepository.saveAndFlush(activity);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean checkActivity(Integer draftID, Integer adminID, String opinion,Integer result) {
        try {
            ActivityDraft draft = activityDraftRepository.getById(draftID);
            if(draft == null || draft.getStatus() != 1){
                return false;
            }


            CheckDraft checkDraft = new CheckDraft();
            checkDraft.setActivityDraftId(draftID);
            checkDraft.setCheckTime(new Timestamp(System.currentTimeMillis()));
            checkDraft.setOpinion(opinion);
            checkDraft.setResult(result);
            checkDraft.setSeniorAdminId(adminID);

            checkDraftRepository.saveAndFlush(checkDraft);

            if (result.equals(2)){
                draft.setStatus(2);
                activityDraftRepository.saveAndFlush(draft);
                return true;
            }else if (result.equals(1)){
                draft.setStatus(3);
                activityDraftRepository.saveAndFlush(draft);

                Activity activity = new Activity(draft);
                activity.setSeniorAdminId(adminID);
                activity.setReleaseTime(new Timestamp(System.currentTimeMillis()));

                activityRepository.saveAndFlush(activity);
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
