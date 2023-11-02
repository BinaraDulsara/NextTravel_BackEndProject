package com.dulz.packageserver.service;

import com.dulz.packageserver.dto.PackageDTO;
import com.dulz.packageserver.entity.PackageEntity;
import com.dulz.packageserver.repo.PackageRepo;
import com.dulz.packageserver.util.DataConverter;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class PackageServiceIMPL implements PackageService{

    @Autowired
    PackageRepo packageRepo;

    @Autowired
    DataConverter dataConverter;



    @Override
    public void savePackage(PackageDTO packageDTO) {
        if (packageRepo.existsById(packageDTO.getPackageId())){
            throw new RuntimeException(packageDTO.getPackageId()+" Package Id Already Exists !!");
        }
        packageRepo.save(dataConverter.packageDTOToPackageEntity(packageDTO));
    }

    @Override
    public void updatePackage(PackageDTO packageDTO) {
        if(!packageRepo.existsById(packageDTO.getPackageId())){
            throw new RuntimeException((packageDTO.getPackageId())+" Package Id Does Not Exists !! ");
        }
        packageRepo.save(dataConverter.packageDTOToPackageEntity(packageDTO));
    }

    @Override
    public void deletePackage(String id) {
        if (!packageRepo.existsById(id)) {
            throw new RuntimeException(id + " Package Is Not In The System !! ");
        }
        packageRepo.deleteById(id);

    }

    @Override
    public PackageDTO findById(String id) {
        if (!packageRepo.existsById(id)) {
            throw new RuntimeException(id + " Package Is Not In The System !! ");
        }
        PackageEntity packageEntity = packageRepo.findById(id).get();
        return dataConverter.packageEntityToPackageDTO(packageEntity);

    }

    @Override
    public List<PackageDTO> getAll() {
        return dataConverter.packageEntityListToPackageDTOList(packageRepo.findAll());
    }

    @Override
    public PackageDTO getPackageByPackageCategory(String packageCategory) {
        return dataConverter.packageEntityToPackageDTO(packageRepo.findPackageByPackageCategory(packageCategory));
    }

    @Override
    public int getCountOfPackage() {
        return packageRepo.getCountOfPackage();
    }

    @Override
    public String getLastIndex() {
        return packageRepo.getLastIndex();
    }


}
