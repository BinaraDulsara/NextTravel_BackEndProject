package com.dulz.VehicleServer.controller;

import com.dulz.VehicleServer.dto.VehicleDTO;
import com.dulz.VehicleServer.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<String>saveVehicle(@RequestBody VehicleDTO vehicleDTO){
        vehicleService.saveVehicle(vehicleDTO);
        return new ResponseEntity<>(vehicleDTO.getVehicleId()+" Vehicle Saved  !! ", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String>updateVehicle(@RequestBody VehicleDTO vehicleDTO){
        vehicleService.updateVehicle(vehicleDTO);
        return new ResponseEntity<>(vehicleDTO.getVehicleId()+" Vehicle Updated !! ",HttpStatus.OK);
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

}
