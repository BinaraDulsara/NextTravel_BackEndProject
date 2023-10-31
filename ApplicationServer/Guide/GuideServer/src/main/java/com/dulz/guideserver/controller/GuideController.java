package com.dulz.guideserver.controller;

import com.dulz.guideserver.dto.GuideDTO;
import com.dulz.guideserver.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/guide")
public class GuideController {

    @Autowired
    GuideService guideService;

    @PostMapping
    public ResponseEntity<String>saveGuide(@RequestBody GuideDTO guideDTO){
        guideService.saveGuide(guideDTO);
        return new ResponseEntity<>(guideDTO.getGuideId()+ " Guide Saved ", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String>updateGuide(@RequestBody GuideDTO guideDTO){
        guideService.updateGuide(guideDTO);
        return new ResponseEntity<>(guideDTO.getGuideId()+ " Guide Updated ",HttpStatus.OK);
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<String>deleteGuide(String id){
        guideService.deleteGuide(id);
        return  new ResponseEntity<>(id+" Guide Deleted ",HttpStatus.OK);
    }
    @GetMapping(params = "id")
    public ResponseEntity<GuideDTO>findById(String id){
        return new ResponseEntity<>( guideService.findById(id),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<GuideDTO>>getAll(){
        return new ResponseEntity<>(guideService.getAll(),HttpStatus.OK);
    }


}
