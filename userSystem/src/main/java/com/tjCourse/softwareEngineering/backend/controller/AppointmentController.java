package com.tjCourse.softwareEngineering.backend.controller;

import com.tjCourse.softwareEngineering.backend.service.implementation.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/appointments")
public class AppointmentController {
    @Autowired
    AppointmentServiceImpl appointmentService;

    @PostMapping(value = "")
    public ResponseEntity<Boolean> addAppointment(@RequestParam("userID")Integer userID,@RequestParam("activityID")Integer activityID){
        return new ResponseEntity<>(appointmentService.addAppointment(userID,activityID), HttpStatus.OK);
    }

    @PutMapping(value = "")
    public ResponseEntity<Boolean> deleteAppointment(@RequestParam("userID")Integer userID,@RequestParam("activityID")Integer activityID){
        return new ResponseEntity<>(appointmentService.deleteAppointment(userID,activityID),HttpStatus.OK);
    }

    @GetMapping(value = "/num/{activityID}")
    public ResponseEntity<Integer> getAppointmentNumber(@PathVariable Integer activityID){
        return new ResponseEntity<>(appointmentService.countByActivityId(activityID),HttpStatus.OK);
    }
}
