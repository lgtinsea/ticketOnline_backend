package com.tjCourse.softwareEngineering.backend.service;

import com.tjCourse.softwareEngineering.backend.entity.Comment;
import com.tjCourse.softwareEngineering.common.service.CURDService;

import java.util.List;

public interface CommentService extends CURDService<Comment,Integer> {
    public List<Comment> getActivityComment(Integer activity_ID);

    public Boolean updateComment(Integer comment_ID, Boolean if_appeared);
}
