package com.dulz.hotelserver.controller;

import com.dulz.hotelserver.dto.HotelDTO;
import com.dulz.hotelserver.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("api/v1/hotel")

public class HotelController {

    @Autowired
    HotelService hotelService;

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////fix post

    @PostMapping
    public ResponseEntity<String>saveHotel(@RequestBody HotelDTO hotelDTO){
        hotelService.saveHotel(hotelDTO);
        return new ResponseEntity<>(hotelDTO.getHotelId()+" Hotel Saved !! ", HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<String> saveHotel(
            @RequestParam("hotelId")String hotelId,
            @RequestParam("hotelName")String hotelName,
            @RequestParam("hotelRate")String hotelRate,
            @RequestParam("hotelCategory")String hotelCategory,
            @RequestParam("hotelLocation")String hotelLocation,
            @RequestParam("hotelCoordinates")String hotelCoordinates,
            @RequestParam("hotelEmail")String hotelEmail,
            @RequestParam("hotelNumber1")String hotelNumber1,
            @RequestParam("hotelNumber2")String hotelNumber2,
            @RequestParam("petsAllowed")String petsAllowed,
            @RequestParam("hotelFee")double hotelFee,
            @RequestParam("cancellationCriteria")String cancellationCriteria,
            @RequestParam("hotelImage") MultipartFile hotelImage
    ){
        try {
            hotelService.saveHotel(new HotelDTO(
                    hotelId,
                    hotelName,
                    hotelRate,
                    hotelCategory,
                    hotelLocation,
                    hotelCoordinates,
                    hotelEmail,
                    hotelNumber1,
                    hotelNumber2,
                    petsAllowed,
                    hotelFee,
                    cancellationCriteria,
                    Base64.getEncoder().encodeToString(hotelImage.getBytes())
            ));
        } catch (IOException e) {
            throw new RuntimeException("Image Cannot Find..!!");
        }
        return new ResponseEntity<>(hotelId+" Hotel is Saved..!!", HttpStatus.OK);
    }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////fix put
    @PutMapping
    public ResponseEntity<String>updateHotel(@RequestBody HotelDTO hotelDTO){
        hotelService.updateHotel(hotelDTO);
        return new ResponseEntity<>(hotelDTO.getHotelId()+" Hotel Updated !! ",HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<String> updateHotel(
            @RequestParam("hotelId")String hotelId,
            @RequestParam("hotelName")String hotelName,
            @RequestParam("hotelRate")String hotelRate,
            @RequestParam("hotelCategory")String hotelCategory,
            @RequestParam("hotelLocation")String hotelLocation,
            @RequestParam("hotelCoordinates")String hotelCoordinates,
            @RequestParam("hotelEmail")String hotelEmail,
            @RequestParam("hotelNumber1")String hotelNumber1,
            @RequestParam("hotelNumber2")String hotelNumber2,
            @RequestParam("petsAllowed")String petsAllowed,
            @RequestParam("hotelFee")double hotelFee,
            @RequestParam("cancellationCriteria")String cancellationCriteria,
            @RequestParam("hotelImage") MultipartFile hotelImage
    ){
        try {
            hotelService.updateHotel(new HotelDTO(
                    hotelId,
                    hotelName,
                    hotelRate,
                    hotelCategory,
                    hotelLocation,
                    hotelCoordinates,
                    hotelEmail,
                    hotelNumber1,
                    hotelNumber2,
                    petsAllowed,
                    hotelFee,
                    cancellationCriteria,
                    Base64.getEncoder().encodeToString(hotelImage.getBytes())
            ));
        } catch (IOException e) {
            throw new RuntimeException("Image Cannot Find..!!");
        }
        return new ResponseEntity<>(hotelId+" Hotel is Updated..!!", HttpStatus.OK);
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

    //get all hotels by package category
    @GetMapping(params = "hotelCategory",path = "/getAllHotelsByPackageCategory")
    public ResponseEntity<List<HotelDTO>> getAllHotelsByPackageCategory(String hotelCategory){
        return new ResponseEntity<>(hotelService.getAllHotelsByPackageCategory(hotelCategory),HttpStatus.OK);
    }

    //get all hotels by package category,hotelRate,hotelLocation
    @GetMapping(params = {"packageCategory","starRate","hotelLocation"},path = "/getAllHotelsByStarRateAndLocation")
    public ResponseEntity<List<HotelDTO>> getAllHotelsByStarRateAndLocation(String packageCategory, String starRate, String hotelLocation){
        return new ResponseEntity<>(hotelService.getAllHotelsByHotelCategoryAndStarRateAndLocation(packageCategory,starRate,hotelLocation),HttpStatus.OK);
    }

    //get all hotel ids
    @GetMapping(path = "/getAllHotelIds")
    public ResponseEntity<List<String>> getAllHotelIds(){
        List<String> hotelIds = null;
        List<HotelDTO> allHotels = hotelService.getAll();
        for(HotelDTO hotelDTO : allHotels){
            hotelIds.add(hotelDTO.getHotelId());
        }
        return new ResponseEntity<>(hotelIds,HttpStatus.OK);
    }

    //get count of hotels
    @GetMapping(path = "/getCountOfHotels")
    public ResponseEntity<Integer> getCountOfHotels(){
        return new ResponseEntity<>(hotelService.getCountOfHotels(),HttpStatus.OK);
    }

    //get last index of HotelId
    @GetMapping(path = "/getLastId")
    public ResponseEntity<String> getLastId(){
        return new ResponseEntity<>(hotelService.getLastIndex(),HttpStatus.OK);
    }

}
