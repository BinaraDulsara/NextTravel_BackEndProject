package com.dulz.VehicleServer.repo;

import com.dulz.VehicleServer.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepo extends JpaRepository<VehicleEntity,String> {

    List<VehicleEntity>findAllByVehicleType( String VehicleType);

}
