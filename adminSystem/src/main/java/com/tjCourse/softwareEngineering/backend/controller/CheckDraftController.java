package com.tjCourse.softwareEngineering.backend.controller;

import com.tjCourse.softwareEngineering.backend.pojo.CheckDraft;
import com.tjCourse.softwareEngineering.common.controller.CURDController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/activities/check",produces = "application/json;charset=utf-8")
public class CheckDraftController {
    @GetMapping(value = "/{draftID}")
    public ResponseEntity<List<CheckDraft>> getCheckDraft(@PathVariable String draftID){
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
