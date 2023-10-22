package com.dulz.VehicleServer.repo;

import com.dulz.VehicleServer.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<VehicleEntity,String> {
}
