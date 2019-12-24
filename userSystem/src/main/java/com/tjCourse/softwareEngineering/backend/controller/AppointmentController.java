package com.tjCourse.softwareEngineering.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/appointments")
public class AppointmentController {
    @PostMapping(value = "")
    public ResponseEntity<Boolean> addAppointment(@RequestParam("userID")Integer userID,@RequestParam("activityID")Integer activityID){
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping(value = "")
    public ResponseEntity<Boolean> deleteAppointment(@RequestParam("userID")Integer userID,@RequestParam("activityID")Integer activityID,@RequestParam("status")Integer status){
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @GetMapping(value = "/num/{activityID}")
    public ResponseEntity<Integer> getAppointmentNumber(@PathVariable Integer activityID){
        return new ResponseEntity<>(null,HttpStatus.OK);
    }
}
