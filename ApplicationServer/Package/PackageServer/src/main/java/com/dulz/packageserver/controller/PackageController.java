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

    //get all package names
    @GetMapping(path = "/getPackageNameList")
    public ResponseEntity<List<String>> getPackageNameList(){
        List<String> packageNameList = null;
        List<PackageDTO> allPackages = packageService.getAll();
        for(PackageDTO packageDTO : allPackages){
            packageNameList.add(packageDTO.getPackageCategory());
        }
        return new ResponseEntity<>(packageNameList,HttpStatus.OK);
    }
    //get package by package category
    @GetMapping(params = "packageCategory",path = "getPackageByPackageCategory")
    public ResponseEntity<PackageDTO> getPackageByPackageCategory(String packageCategory){
        return new ResponseEntity<>(packageService.getPackageByPackageCategory(packageCategory),HttpStatus.OK);
    }
    //get count of packages
    @GetMapping(path = "/getCountOfPackage")
    public ResponseEntity<Integer>  getCountOfPackage(){
        return new ResponseEntity<>(packageService.getCountOfPackage(),HttpStatus.OK);
    }
    //get last index of Package id
    @GetMapping(path = "/getLastId")
    public ResponseEntity<String> getLastId(){
        return new ResponseEntity<>(packageService.getLastIndex(),HttpStatus.OK);
    }





}
