package com.dulz.VehicleServer.util;

import com.dulz.VehicleServer.dto.VehicleDTO;
import com.dulz.VehicleServer.entity.VehicleEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DataConverter {

    @Autowired
    ModelMapper modelMapper;

    public VehicleEntity  vehicleDTOTvehicleEntity (VehicleDTO vehicleDTO){
        return modelMapper.map(vehicleDTO, VehicleEntity.class);
    }

    public VehicleDTO vehicleEntityToVehicleDTO(VehicleEntity vehicleEntity){
        return modelMapper.map(vehicleEntity, VehicleDTO.class);
    }

    public List<VehicleDTO> vehicleEntityListTovehicleDTOList(List<VehicleEntity> packages){
        return modelMapper.map(packages,new TypeToken<List<VehicleDTO>>(){}.getType());
    }

}
