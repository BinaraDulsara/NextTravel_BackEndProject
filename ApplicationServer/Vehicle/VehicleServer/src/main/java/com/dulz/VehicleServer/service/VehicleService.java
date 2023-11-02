package com.dulz.VehicleServer.service;

import com.dulz.VehicleServer.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {

    void saveVehicle(VehicleDTO vehicleDTO);

    void updateVehicle(VehicleDTO vehicleDTO);

    void deleteVehicle(String id);

    VehicleDTO findById(String id);

    List<VehicleDTO> getAll();

    List<VehicleDTO> getAllVehiclesByCategory(String category);

    List<VehicleDTO> getAllVehiclesByCategorySeatCapacityTransmissionTypeFuelType(
            String category,
            int seatCapacity,
            String transmissionType,
            String fuelType
    );

    int getCountOfVehicles();
}
