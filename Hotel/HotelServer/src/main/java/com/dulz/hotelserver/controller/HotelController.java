package com.dulz.hotelserver.controller;

import com.dulz.hotelserver.dto.HotelDTO;
import com.dulz.hotelserver.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/hotel")

public class HotelController {

    @Autowired
    HotelService hotelService;

    @PostMapping
    public ResponseEntity<String>saveHotel(@RequestBody HotelDTO hotelDTO){
        hotelService.saveHotel(hotelDTO);
        return new ResponseEntity<>(hotelDTO.getHotelId()+" Hotel Saved !! ", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String>updateHotel(@RequestBody HotelDTO hotelDTO){
        hotelService.updateHotel(hotelDTO);
        return new ResponseEntity<>(hotelDTO.getHotelId()+" Hotel Updated !! ",HttpStatus.OK);
    }


    @DeleteMapping(params = "id")
    public ResponseEntity<String> deleteById(String id){
        hotelService.deleteHotel(id);
        return new ResponseEntity<>(id+" Hotel Is Deleted " , HttpStatus.OK);
    }

    @GetMapping(params = "id")
    public ResponseEntity<HotelDTO>findById(String id){
        return new ResponseEntity<>(hotelService.findById(id),HttpStatus.OK);
    }

    @GetMapping
    public  ResponseEntity<List<HotelDTO>>getAll(){
        return new ResponseEntity<>( hotelService.getAll(),HttpStatus.OK);
    }
}
