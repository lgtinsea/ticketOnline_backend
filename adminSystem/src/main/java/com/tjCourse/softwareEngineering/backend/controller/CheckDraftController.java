package com.tjCourse.softwareEngineering.backend.controller;

import com.tjCourse.softwareEngineering.backend.entity.CheckDraft;
import com.tjCourse.softwareEngineering.backend.service.Implementation.CheckDraftServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    CheckDraftServiceImpl checkDraftService;


    @GetMapping(value = "/{draftID}")
    public ResponseEntity<List<CheckDraft>> getCheckDraft(@PathVariable Integer draftID){
        return new ResponseEntity<>(checkDraftService.getByActivityDraftId(draftID), HttpStatus.OK);
    }
}
