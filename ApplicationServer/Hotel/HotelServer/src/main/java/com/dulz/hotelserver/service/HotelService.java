package com.dulz.hotelserver.service;

import com.dulz.hotelserver.dto.HotelDTO;

import java.util.List;

public interface HotelService {

    void saveHotel(HotelDTO hotelDTO);

    void updateHotel(HotelDTO hotelDTO);

    void deleteHotel(String id);

    HotelDTO findById(String id);

    List<HotelDTO>getAll();

    List<HotelDTO> getAllHotelsByPackageCategory(String packageCategory);
    List<HotelDTO> getAllHotelsByHotelCategoryAndStarRateAndLocation(String packageCategory, String starRate,String hotelLocation);
    String getLastIndex();
    int getCountOfHotels();
}
