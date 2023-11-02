package com.dulz.VehicleServer.controller;

import com.dulz.VehicleServer.dto.VehicleDTO;
import com.dulz.VehicleServer.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicle")
@RequiredArgsConstructor

public class VehicleController {

    @Autowired
    VehicleService vehicleService;


    @PostMapping
    public ResponseEntity<String> saveVehicle(
            @RequestParam("vehicleId") String vehicleId,
            @RequestParam("vehicleRegId") String vehicleRegId,
            @RequestParam("vehiclebrand") String vehiclebrand,
            @RequestParam("vehicleCategory") String vehicleCategory,
            @RequestParam("vehicleFueltype") String vehicleFueltype,
            @RequestParam("hybridStatus") String hybridStatus,
            @RequestParam("vehicleFuelUsage") int vehicleFuelUsage,
            @RequestParam("vehicleSeatCapacity") int vehicleSeatCapacity,
            @RequestParam("vehicleType") String vehicleType,
            @RequestParam("transmissionType") String transmissionType,
            @RequestParam("vehicleDriverName") String vehicleDriverName,
            @RequestParam("vehicleDriveNumber") String vehicleDriveNumber,
            @RequestParam("driverLicense") MultipartFile driverLicense,
            @RequestParam("rearView") MultipartFile rearView
    ){
        try {
            vehicleService.saveVehicle(new VehicleDTO(
                    vehicleId,
                    vehicleRegId,
                    vehiclebrand,
                    vehicleCategory,
                    vehicleFueltype,
                    hybridStatus,
                    vehicleFuelUsage,
                    vehicleSeatCapacity,
                    vehicleType,
                    transmissionType,
                    vehicleDriverName,
                    vehicleDriveNumber,
                    Base64.getEncoder().encodeToString(driverLicense.getBytes()),
                    Base64.getEncoder().encodeToString(rearView.getBytes())
            ));
        } catch (IOException e) {
            throw new RuntimeException("Image Not Found..!!");
        }
        return new ResponseEntity<>(vehicleRegId+" Vehicle saved successfully..!!", HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<String> updateVehicle(
            @RequestParam("vehicleId") String vehicleId,
            @RequestParam("vehicleRegId") String vehicleRegId,
            @RequestParam("vehiclebrand") String vehiclebrand,
            @RequestParam("vehicleCategory") String vehicleCategory,
            @RequestParam("vehicleFueltype") String vehicleFueltype,
            @RequestParam("hybridStatus") String hybridStatus,
            @RequestParam("vehicleFuelUsage") int vehicleFuelUsage,
            @RequestParam("vehicleSeatCapacity") int vehicleSeatCapacity,
            @RequestParam("vehicleType") String vehicleType,
            @RequestParam("transmissionType") String transmissionType,
            @RequestParam("vehicleDriverName") String vehicleDriverName,
            @RequestParam("vehicleDriveNumber") String vehicleDriveNumber,
            @RequestParam("driverLicense") MultipartFile driverLicense,
            @RequestParam("rearView") MultipartFile rearView)
    {
        try {
            vehicleService.updateVehicle(new VehicleDTO(
                    vehicleId,
                    vehicleRegId,
                    vehiclebrand,
                    vehicleCategory,
                    vehicleFueltype,
                    hybridStatus,
                    vehicleFuelUsage,
                    vehicleSeatCapacity,
                    vehicleType,
                    transmissionType,
                    vehicleDriverName,
                    vehicleDriveNumber,
                    Base64.getEncoder().encodeToString(driverLicense.getBytes()),
                    Base64.getEncoder().encodeToString(rearView.getBytes())
            ));
        } catch (IOException e) {
            throw new RuntimeException("Image not Found..!!");
        }
        return new ResponseEntity<>(vehicleRegId+" Vehicle Updated Successfully",HttpStatus.OK);
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<String>deleteById(String id){
        vehicleService.deleteVehicle(id);
        return new ResponseEntity<>(id+" Vehicle Deleted !! ",HttpStatus.OK);
    }

    @GetMapping(params = "id")
    public ResponseEntity<VehicleDTO>findById(String id){
        return new ResponseEntity<>(vehicleService.findById(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<VehicleDTO>>getAll(){
        return new ResponseEntity<>(vehicleService.getAll(),HttpStatus.OK);
    }

    @GetMapping(params = "vehicleCategory",path = "/getAllVehiclesByCategory")
    public ResponseEntity<List<VehicleDTO>> getAllVehiclesByCategory(String vehicleCategory){
        return new ResponseEntity<>(vehicleService.getAllVehiclesByCategory(vehicleCategory),HttpStatus.OK);
    }

    @GetMapping(params = {"vehicleCategory","vehicleSeatCapacity","transmissionType","vehicleFueltype"},path = "/getAllVehiclesByVehicleTypeSeatCapacityTransmissionTypeFuelType")
    public ResponseEntity<List<VehicleDTO>> getAllVehiclesByVehicleTypeSeatCapacityTransmissionTypeFuelType(
            String vehicleCategory,
            int vehicleSeatCapacity,
            String transmissionType,
            String vehicleFueltype
    ){
        return new ResponseEntity<>(vehicleService.getAllVehiclesByCategorySeatCapacityTransmissionTypeFuelType(vehicleCategory,vehicleSeatCapacity,transmissionType,vehicleFueltype),HttpStatus.OK);
    }

    @GetMapping(path = "/getVehicleRegistrationNumbers")
    public ResponseEntity<List<String>> getVehicleRegistrationNumbers(){
        List<String> registrationNumbers = null;
        List<VehicleDTO> allVehicles = vehicleService.getAll();
        for(VehicleDTO vehicleDTO : allVehicles){
            registrationNumbers.add(vehicleDTO.getVehicleRegId());
        }
        return new ResponseEntity<>(registrationNumbers,HttpStatus.OK);
    }

    @GetMapping(path = "/getCountOfVehicles")
    public ResponseEntity<Integer> getCountOfVehicles(){
        return new ResponseEntity<>(vehicleService.getCountOfVehicles(),HttpStatus.OK);
    }

}
