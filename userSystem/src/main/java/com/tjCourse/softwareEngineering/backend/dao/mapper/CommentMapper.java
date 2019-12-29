package com.tjCourse.softwareEngineering.backend.dao.mapper;

import com.tjCourse.softwareEngineering.backend.dto.ReturnCommentDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {
    public List<ReturnCommentDTO> getActivityComment(Integer activity_ID);
}
