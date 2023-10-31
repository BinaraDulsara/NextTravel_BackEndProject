package com.dulz.hotelserver.service;

import com.dulz.hotelserver.dto.HotelDTO;
import com.dulz.hotelserver.entity.HotelEntity;
import com.dulz.hotelserver.repo.HotelRepo;
import com.dulz.hotelserver.util.DataConverter;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class HotelServiceIMPL implements HotelService{

    @Autowired
    HotelRepo hotelRepo;

    @Autowired
    DataConverter dataConverter;

    @Override
    public void saveHotel(HotelDTO hotelDTO) {
        if (hotelRepo.existsById(hotelDTO.getHotelId())) {
            throw new RuntimeException(hotelDTO.getHotelId() + "Hotel Id Already Exists !! ");
        }
        hotelRepo.save(dataConverter.HotelDTOTOHotelEntity(hotelDTO));

    }

    @Override
    public void updateHotel(HotelDTO hotelDTO) {
        if (!hotelRepo.existsById(hotelDTO.getHotelId())){
            throw new RuntimeException(hotelDTO.getHotelId()+ "Hotel Id Does Not Exists !!");
        }
    hotelRepo.save(dataConverter.HotelDTOTOHotelEntity(hotelDTO));
    }

    @Override
    public void deleteHotel(String id) {
        if (!hotelRepo.existsById(id)){
            throw new RuntimeException(id+" Hotel Is Not In The System !! ");
        }
        hotelRepo.deleteById(id);
    }

    @Override
    public HotelDTO findById(String id) {
        if (!hotelRepo.existsById(id)){
            throw new RuntimeException(id+" Hotel Is Not In The System !! ");
        }
        return dataConverter.HotelEntityToHotelDTO(hotelRepo.findById(id).get());
    }

    @Override
    public List<HotelDTO> getAll(){
        return dataConverter.packageEntityListToPackageDTOList(hotelRepo.findAll());
       }


}
