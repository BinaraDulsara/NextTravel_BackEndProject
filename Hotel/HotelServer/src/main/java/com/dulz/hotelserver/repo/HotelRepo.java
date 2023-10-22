package com.dulz.hotelserver.repo;

import com.dulz.hotelserver.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<HotelEntity,String> {

}
