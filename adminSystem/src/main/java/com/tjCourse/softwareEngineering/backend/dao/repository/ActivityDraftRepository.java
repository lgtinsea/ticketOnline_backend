package com.tjCourse.softwareEngineering.backend.dao.repository;

import com.tjCourse.softwareEngineering.backend.dto.ReturnDraftDTO;
import com.tjCourse.softwareEngineering.backend.entity.ActivityDraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActivityDraftRepository extends JpaRepository<ActivityDraft,Integer> {
    @Query(value = "select new com.tjCourse.softwareEngineering.backend.dto.ReturnDraftDTO(id,activityId,name,status) from ActivityDraft where status = 1 or status = 2")
    public List<ReturnDraftDTO> getAllDraftInfo();

    @Query(value = "select new com.tjCourse.softwareEngineering.backend.dto.ReturnDraftDTO(id,activityId,name,status) from ActivityDraft where organizationID = :organization_ID and (status = 1 or status =2)")
    public List<ReturnDraftDTO> getDepartDraftInfo(Integer organization_ID);

    @Query(value = "select new com.tjCourse.softwareEngineering.backend.dto.ReturnDraftDTO(id,activityId,name,status) from ActivityDraft where status = :status")
    public List<ReturnDraftDTO> getDraftInfoByStatus(Integer status);

    public ActivityDraft getById(Integer draftID);
}
