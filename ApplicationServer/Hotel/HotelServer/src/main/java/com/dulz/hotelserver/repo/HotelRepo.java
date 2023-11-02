package com.dulz.hotelserver.repo;

import com.dulz.hotelserver.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HotelRepo extends JpaRepository<HotelEntity,String> {

    List<HotelEntity> findAllByPackageCategory(String packageCategory);
    List<HotelEntity> findAllByPackageCategoryAndStarRateAndHotelLocation(String hotelCategory, String starRate,String hotelLocation);
    boolean existsByPackageCategory(String packageCategory);
    boolean existsByStarRate(String starRate);
    boolean existsByHotelLocation(String hotelLocation);

    @Query(value = "SELECT COUNT(*) FROM Hotels",nativeQuery=true)
    int getCountOfHotels();

    @Query(value = "SELECT hotelId FROM Hotel ORDER BY hotelId DESC LIMIT 1",nativeQuery = true)
    String getLastIndex();

}
