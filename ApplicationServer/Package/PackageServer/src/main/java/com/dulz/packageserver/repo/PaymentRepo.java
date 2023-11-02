package com.dulz.packageserver.repo;

import com.dulz.packageserver.entity.PackageEntity;
import com.dulz.packageserver.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface PaymentRepo extends JpaRepository<PaymentEntity,String> {

    @Query(value = "SELECT payment.date,count(payment.bookingId),sum(payment.price) FROM Payment GROUP BY date", nativeQuery = true)
    ArrayList dailyIncome();

    @Query(value = "SELECT (MONTHNAME(date )) ,count(payment.bookingId),sum(payment.price)FROM  Payment  GROUP BY extract(MONTH FROM(date))", nativeQuery = true)
    ArrayList monthlyIncome();

    @Query(value = "SELECT (YEAR(date )) ,count(payment.bookingId),sum(payment.price)FROM Payment GROUP BY extract(YEAR FROM(date))", nativeQuery = true)
    ArrayList AnnuallyIncome();
}
