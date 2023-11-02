package com.dulz.packageserver.repo;

import com.dulz.packageserver.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepo extends JpaRepository<BookEntity,String> {
    @Query(value = "SELECT bookingId FROM Booking ORDER BY bookingId DESC LIMIT 1",nativeQuery = true)
    String getLastIndex();

    BookEntity findBookingByUserId(String userId);

    List<BookEntity> findBookingsByUserId(String userId);

    @Query(value = "SELECT COUNT(*) FROM Booking",nativeQuery=true)
    int getCountOfBookings();
}
