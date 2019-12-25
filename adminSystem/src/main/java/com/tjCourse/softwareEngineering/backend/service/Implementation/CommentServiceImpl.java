package com.tjCourse.softwareEngineering.backend.service.Implementation;

import com.tjCourse.softwareEngineering.backend.dao.repository.CommentRepository;
import com.tjCourse.softwareEngineering.backend.pojo.Comment;
import com.tjCourse.softwareEngineering.backend.service.CommentService;
import com.tjCourse.softwareEngineering.common.service.implementation.CURDServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends CURDServiceImpl<Comment,Integer, CommentRepository> implements CommentService {
}
