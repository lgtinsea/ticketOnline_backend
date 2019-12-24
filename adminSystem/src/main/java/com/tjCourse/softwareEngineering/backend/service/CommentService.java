package com.tjCourse.softwareEngineering.backend.service;

import com.tjCourse.softwareEngineering.backend.pojo.Comment;
import com.tjCourse.softwareEngineering.common.service.CURDService;
import org.springframework.stereotype.Service;

@Service
public interface CommentService extends CURDService<Comment,Integer> {
}
