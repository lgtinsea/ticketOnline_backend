package com.tjCourse.softwareEngineering.backend.service.Implementation;

import com.tjCourse.softwareEngineering.backend.dao.repository.CommentRepository;
import com.tjCourse.softwareEngineering.backend.entity.Comment;
import com.tjCourse.softwareEngineering.backend.service.CommentService;
import com.tjCourse.softwareEngineering.common.service.implementation.CURDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl extends CURDServiceImpl<Comment,Integer, CommentRepository> implements CommentService {
   @Autowired CommentRepository commentRepository;

    @Override
    public List<Comment> getActivityComment(Integer activity_ID) {
        return commentRepository.getByActivityId(activity_ID);
    }

    @Override
    public Boolean updateComment(Integer comment_ID, Boolean if_appeared) {
        try {
            Comment comment = commentRepository.getOne(comment_ID);

            if (if_appeared){
                if (comment.getIfAppeared()){
                    return false;
                }
                comment.setIfAppeared(true);
                commentRepository.saveAndFlush(comment);
                return true;
            }else {
                if (!comment.getIfAppeared()){
                    return false;
                }

                comment.setIfAppeared(false);
                commentRepository.saveAndFlush(comment);
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
