package com.dulz.packageserver.repo;

import com.dulz.packageserver.dto.PackageDTO;
import com.dulz.packageserver.entity.PackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepo extends JpaRepository<PackageEntity,String> {

}
