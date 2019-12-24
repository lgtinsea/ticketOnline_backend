package com.tjCourse.softwareEngineering.backend.controller;

import com.tjCourse.softwareEngineering.backend.DTO.ReturnDraftDTO;
import com.tjCourse.softwareEngineering.backend.pojo.ActivityDraft;
import com.tjCourse.softwareEngineering.backend.service.ActivityDraftService;
import com.tjCourse.softwareEngineering.common.controller.CURDController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/drafts",produces = "application/json;charset=utf-8")
public class ActivityDraftController extends CURDController<ActivityDraft,Integer,ActivityDraftService> {
    @GetMapping(value = "/checking/basic")
    public ResponseEntity<List<ReturnDraftDTO>> getCheckingDraftBasicInfo(@RequestParam("ID")Integer ID,@RequestParam("role")Integer role){
        if (role.equals(1)){
            return new ResponseEntity<>(null, HttpStatus.OK);
        } else if (role.equals(2)){
            return new ResponseEntity<>(null,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(value = "/editing/basic")
    public ResponseEntity<List<ReturnDraftDTO>> getEditingDraftBasicInfo(@RequestParam("ID")Integer adminID){
        return new ResponseEntity<>(null,HttpStatus.OK);
    }
}
