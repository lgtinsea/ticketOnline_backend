package com.tjCourse.softwareEngineering.backend.controller;

import com.tjCourse.softwareEngineering.backend.dto.ReturnCommentDTO;
import com.tjCourse.softwareEngineering.backend.entity.Comment;
import com.tjCourse.softwareEngineering.backend.service.CommentService;
import com.tjCourse.softwareEngineering.backend.service.implementation.CommentServiceImpl;
import com.tjCourse.softwareEngineering.common.controller.CURDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/comments",produces = "application/json;charset=utf-8")
public class CommentController extends CURDController<Comment,Integer, CommentService> {
    @Autowired
    CommentServiceImpl commentService;

    @GetMapping(value = "/activities/{activityID}")
    public ResponseEntity<List<ReturnCommentDTO>> getComments(@PathVariable("activityID")Integer activityID){
        return new ResponseEntity<>(commentService.getActivityComment(activityID), HttpStatus.OK);
    }
}
