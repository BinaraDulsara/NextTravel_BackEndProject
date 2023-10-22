package com.dulz.VehicleServer.service;

import com.dulz.VehicleServer.dto.VehicleDTO;
import com.dulz.VehicleServer.entity.VehicleEntity;
import com.dulz.VehicleServer.repo.VehicleRepo;
import com.dulz.VehicleServer.util.DataConverter;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class VehicleServiceIMPL implements VehicleService {

    @Autowired
    VehicleRepo vehicleRepo;

    @Autowired
    DataConverter dataConverter;


    @Override
    public void saveVehicle(VehicleDTO vehicleDTO) {
        if (vehicleRepo.existsById(vehicleDTO.getVehicleId())){
            throw new RuntimeException(vehicleDTO.getVehicleId()+" Vehicle Id Already Exists !!");
        }
        vehicleRepo.save(dataConverter.vehicleDTOTvehicleEntity(vehicleDTO));
    }

    @Override
    public void updateVehicle(VehicleDTO vehicleDTO) {
        if (!vehicleRepo.existsById(vehicleDTO.getVehicleId())){
            throw new RuntimeException(vehicleDTO.getVehicleId()+" Vehicle Id Does Not Exists !! ");
        }
        vehicleRepo.save(dataConverter.vehicleDTOTvehicleEntity(vehicleDTO));

    }

    @Override
    public void deleteVehicle(String id) {
        if (!vehicleRepo.existsById(id)){
            throw new RuntimeException(id+" Vehicle Id Does Not Exists !!");
        }
        vehicleRepo.deleteById(id);
    }

    @Override
    public VehicleDTO findById(String id) {
        if (!vehicleRepo.existsById(id)){
            throw new RuntimeException(id+" Vehicle Id Does Not Exists !! ");
        }
        return dataConverter.vehicleEntityToVehicleDTO( vehicleRepo.findById(id).get());
    }

    @Override
    public List<VehicleDTO> getAll() {
        return dataConverter.vehicleEntityListTovehicleDTOList(vehicleRepo.findAll());
    }
}
