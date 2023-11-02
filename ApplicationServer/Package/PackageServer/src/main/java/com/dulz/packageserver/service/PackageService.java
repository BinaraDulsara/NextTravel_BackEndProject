package com.dulz.packageserver.service;

import com.dulz.packageserver.dto.PackageDTO;

import java.util.List;

public interface PackageService {

    void savePackage(PackageDTO packageDTO);

    void updatePackage(PackageDTO packageDTO);

    void deletePackage(String id);

    PackageDTO findById(String id);

    List<PackageDTO> getAll();

    PackageDTO getPackageByPackageCategory(String packageCategory);

    int getCountOfPackage();

    String getLastIndex();

}
