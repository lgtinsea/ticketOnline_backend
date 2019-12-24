package com.tjCourse.softwareEngineering.backend.controller;

import com.tjCourse.softwareEngineering.backend.pojo.Comment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/comments",produces = "application/json;charset=utf-8")
public class CommentController {
    @GetMapping(value = "/{activityID}")
    public ResponseEntity<List<Comment>> getComments(@PathVariable("activityID")Integer activityID){
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping(value = "")
    public ResponseEntity<Boolean> updateComment(@RequestParam("ID")Integer ID,@RequestParam("ifAppeared")boolean ifAppeared){
        return new ResponseEntity<>(null,HttpStatus.OK);
    }
}
