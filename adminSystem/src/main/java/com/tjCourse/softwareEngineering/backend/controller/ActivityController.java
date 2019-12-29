package com.tjCourse.softwareEngineering.backend.controller;

import com.tjCourse.softwareEngineering.backend.dto.ReturnActivitiesCoverDTO;
import com.tjCourse.softwareEngineering.backend.dto.ReturnActivitiesDTO;
import com.tjCourse.softwareEngineering.backend.dto.ReturnActivityReportDTO;
import com.tjCourse.softwareEngineering.backend.pojo.Activity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/activities",produces = "application/json;charset=utf-8")
public class ActivityController {
    @GetMapping(value = "/basic")
    public ResponseEntity<List<ReturnActivitiesDTO>> getActivitiesBasicInfo(@RequestParam("ID")Integer ID,@RequestParam("role")Integer role){
        if (role.equals(1)){
            return new ResponseEntity<>(null, HttpStatus.OK);
        } else if (role.equals(2)){
            return new ResponseEntity<>(null,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(value = "")
    public ResponseEntity<List<ReturnActivitiesCoverDTO>> getActivitiesCoverInfo(@RequestParam("ID")Integer ID,@RequestParam("role")Integer role){
        if (role.equals(1)){
            return new ResponseEntity<>(null, HttpStatus.OK);
        } else if (role.equals(2)){
            return new ResponseEntity<>(null,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(value = "/report")
    public ResponseEntity<List<ReturnActivityReportDTO>> getActivitiesReport(){
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping(value = "")
    public ResponseEntity<Boolean> updateActivityInfo(@RequestBody Activity activity){
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<Boolean> addActivity(@RequestParam("draftID")Integer draftID){
        return new ResponseEntity<>(null,HttpStatus.OK);
    }
}
