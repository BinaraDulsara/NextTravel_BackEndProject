package com.dulz.hotelserver.util;

import com.dulz.hotelserver.dto.HotelDTO;
import com.dulz.hotelserver.entity.HotelEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataConverter {

    @Autowired
    ModelMapper modelMapper;

    public HotelEntity HotelDTOTOHotelEntity(HotelDTO hotelDTO){
        return modelMapper.map(hotelDTO , HotelEntity.class);
    }

    public HotelDTO HotelEntityToHotelDTO(HotelEntity hotelEntity){
        return modelMapper.map(hotelEntity, HotelDTO.class);
    }

    public List<HotelDTO> packageEntityListToPackageDTOList(List<HotelEntity> hotels){
        return modelMapper.map(hotels,new TypeToken<List<HotelDTO>>(){}.getType());
    }
}
