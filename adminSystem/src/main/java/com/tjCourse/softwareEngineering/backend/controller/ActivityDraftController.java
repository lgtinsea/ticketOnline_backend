package com.tjCourse.softwareEngineering.backend.controller;

import com.tjCourse.softwareEngineering.backend.dto.ReturnDraftDTO;
import com.tjCourse.softwareEngineering.backend.entity.ActivityDraft;
import com.tjCourse.softwareEngineering.backend.service.ActivityDraftService;
import com.tjCourse.softwareEngineering.backend.service.Implementation.ActivityDraftServiceImpl;
import com.tjCourse.softwareEngineering.common.controller.CURDController;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    ActivityDraftServiceImpl activityDraftService;

    @GetMapping(value = "/checking/basic")
    public ResponseEntity<List<ReturnDraftDTO>> getCheckingDraftBasicInfo(@RequestParam("ID")Integer ID,@RequestParam("role")Integer role){
        try {
            List<ReturnDraftDTO> list = activityDraftService.getUncheckedDraft(ID,role);
            if (list == null){
                return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
            }else {
                return new ResponseEntity<>(list,HttpStatus.OK);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }


    }

    @GetMapping(value = "/editing/basic")
    public ResponseEntity<List<ReturnDraftDTO>> getEditingDraftBasicInfo(@RequestParam("ID")Integer adminID){
        try {
            return new ResponseEntity<>(activityDraftService.getEditDraft(),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }
}
