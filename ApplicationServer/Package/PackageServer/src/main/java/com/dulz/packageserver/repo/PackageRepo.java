package com.dulz.packageserver.repo;

import com.dulz.packageserver.dto.PackageDTO;
import com.dulz.packageserver.entity.PackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository

public interface PackageRepo extends JpaRepository<PackageEntity,String> {

    PackageEntity findPackageByPackageCategory(String packageCategory);

    @Query(value = "SELECT COUNT(*) FROM Package",nativeQuery=true)
    int getCountOfPackage();

    @Query(value = "SELECT packageId FROM Package ORDER BY packageId DESC LIMIT 1",nativeQuery = true)
    String getLastIndex();

}
