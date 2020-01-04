package com.tjCourse.softwareEngineering.backend.controller;

import com.tjCourse.softwareEngineering.backend.entity.Comment;
import com.tjCourse.softwareEngineering.backend.service.Implementation.ActivityServiceImpl;
import com.tjCourse.softwareEngineering.backend.service.Implementation.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/comments",produces = "application/json;charset=utf-8")
public class CommentController {
    @Autowired
    CommentServiceImpl commentService;


    @GetMapping(value = "/{activityID}")
    public ResponseEntity<List<Comment>> getComments(@PathVariable("activityID")Integer activityID){
        try {
            return new ResponseEntity<>(commentService.getActivityComment(activityID), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }

    @PutMapping(value = "")
    public ResponseEntity<Boolean> updateComment(@RequestParam("ID")Integer ID,@RequestParam("ifAppeared")boolean ifAppeared){
        try {
            return new ResponseEntity<>(commentService.updateComment(ID,ifAppeared),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }
}
