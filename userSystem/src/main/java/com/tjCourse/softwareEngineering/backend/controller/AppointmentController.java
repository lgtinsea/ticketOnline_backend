package com.tjCourse.softwareEngineering.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/appointments")
public class AppointmentController {
    @PutMapping(value = "")
    public ResponseEntity<Boolean> addAppointment(@RequestParam("userID")Integer userID,@RequestParam("activityID")Integer activityID){
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping(value = "")
    public ResponseEntity<Boolean> deleteAppointment(@RequestParam("userID")Integer userID,@RequestParam("activityID")Integer activityID){
        return new ResponseEntity<>(null,HttpStatus.OK);
    }
}
