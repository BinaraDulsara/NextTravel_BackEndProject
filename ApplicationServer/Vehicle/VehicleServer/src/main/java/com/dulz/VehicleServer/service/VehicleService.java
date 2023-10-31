package com.dulz.VehicleServer.service;

import com.dulz.VehicleServer.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {

    void saveVehicle(VehicleDTO vehicleDTO);

    void updateVehicle(VehicleDTO vehicleDTO);

    void deleteVehicle(String id);

    VehicleDTO findById(String id);

    List<VehicleDTO> getAll();


}
