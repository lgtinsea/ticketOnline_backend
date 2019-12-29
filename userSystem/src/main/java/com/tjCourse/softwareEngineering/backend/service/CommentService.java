package com.tjCourse.softwareEngineering.backend.service;

import com.tjCourse.softwareEngineering.backend.dto.ReturnCommentDTO;
import com.tjCourse.softwareEngineering.backend.entity.Comment;
import com.tjCourse.softwareEngineering.common.service.CURDService;

import java.util.List;

public interface CommentService extends CURDService<Comment,Integer> {
    public List<ReturnCommentDTO> getActivityComment(Integer activity_ID);
}
