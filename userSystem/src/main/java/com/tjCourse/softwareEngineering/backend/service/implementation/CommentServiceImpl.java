package com.tjCourse.softwareEngineering.backend.service.implementation;

import com.tjCourse.softwareEngineering.backend.dao.mapper.CommentMapper;
import com.tjCourse.softwareEngineering.backend.dao.repository.CommentRepository;
import com.tjCourse.softwareEngineering.backend.dto.ReturnCommentDTO;
import com.tjCourse.softwareEngineering.backend.pojo.Comment;
import com.tjCourse.softwareEngineering.backend.service.CommentService;
import com.tjCourse.softwareEngineering.common.service.implementation.CURDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl extends CURDServiceImpl<Comment,Integer, CommentRepository> implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    public List<ReturnCommentDTO> getActivityComment(Integer activity_ID){
        return commentMapper.getActivityComment(activity_ID);
    }

}
