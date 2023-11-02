package com.dulz.VehicleServer.repo;

import com.dulz.VehicleServer.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepo extends JpaRepository<VehicleEntity,String> {

    List<VehicleEntity> findAllByVehicleCategoryAndVehicleSeatCapacityAndTransmissionTypeAndVehicleFueltype(
            String category,
            int seatCapacity,
            String transmissionType,
            String fuelType
    );
    List<VehicleEntity> findAllByVehicleCategory(String category);

    boolean existsByVehicleCategory(String category);

    @Query(value = "SELECT COUNT (*) FROM VehicleEntity ",nativeQuery = true )
    int getCountOfVehicles();
}
