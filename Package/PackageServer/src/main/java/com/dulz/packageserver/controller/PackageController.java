package com.dulz.packageserver.controller;

import com.dulz.packageserver.dto.PackageDTO;
import com.dulz.packageserver.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/package")
public class PackageController {

    @Autowired
    PackageService packageService;

    @PostMapping
    public ResponseEntity<String> savePackage(@RequestBody PackageDTO packageDTO){
        packageService.savePackage(packageDTO);
        return new ResponseEntity<>(packageDTO.getPackageId()+"package saved !!", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String>updatePackage(@RequestBody PackageDTO packageDTO){
        packageService.updatePackage(packageDTO);
        return new  ResponseEntity<>(packageDTO.getPackageId()+"package updated !! ",HttpStatus.OK);
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<String>deleteById(String id){
        packageService.deletePackage(id);
        return new ResponseEntity<>(id+ " Package Deleted ",HttpStatus.OK);
    }

    @GetMapping(params = "id")
    public ResponseEntity<PackageDTO>findById(String id){
        return new ResponseEntity<>(packageService.findById(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PackageDTO>> getAll(){
        return new ResponseEntity<>(packageService.getAll(),HttpStatus.OK);
    }




}
