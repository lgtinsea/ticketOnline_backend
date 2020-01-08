package com.tjCourse.softwareEngineering.backend.controller;

import com.tjCourse.softwareEngineering.backend.service.implementation.AppointmentServiceImpl;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
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
    @RequiresAuthentication
    @RequiresRoles("user")
    public ResponseEntity<Boolean> addAppointment(@RequestParam("userID")Integer userID,@RequestParam("activityID")Integer activityID){
        try {
            return new ResponseEntity<>(appointmentService.addAppointment(userID,activityID), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }

    @PutMapping(value = "")
    @RequiresAuthentication
    @RequiresRoles("user")
    public ResponseEntity<Boolean> deleteAppointment(@RequestParam("userID")Integer userID,@RequestParam("activityID")Integer activityID){
        try {
            return new ResponseEntity<>(appointmentService.deleteAppointment(userID,activityID),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value = "/num/{activityID}")
    public ResponseEntity<Integer> getAppointmentNumber(@PathVariable Integer activityID){
        try {
            return new ResponseEntity<>(appointmentService.countByActivityId(activityID),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value = "/check")
    public ResponseEntity<Boolean> checkIfAppointment(@RequestParam Integer user_ID, @RequestParam Integer activity_ID){
        try {
            return new ResponseEntity<>(appointmentService.findIfAppointment(user_ID,activity_ID),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.CONFLICT);
        }
    }
}
