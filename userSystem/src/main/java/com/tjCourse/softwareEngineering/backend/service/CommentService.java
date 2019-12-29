package com.tjCourse.softwareEngineering.backend.service;

import com.tjCourse.softwareEngineering.backend.dto.ReturnCommentDTO;
import com.tjCourse.softwareEngineering.backend.pojo.Comment;
import com.tjCourse.softwareEngineering.common.service.CURDService;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommentService extends CURDService<Comment,Integer> {
    public List<ReturnCommentDTO> getActivityComment(Integer activity_ID);
}
