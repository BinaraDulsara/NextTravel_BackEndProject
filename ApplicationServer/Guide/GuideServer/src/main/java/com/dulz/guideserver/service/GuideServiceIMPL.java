package com.dulz.guideserver.service;

import com.dulz.guideserver.dto.GuideDTO;
import com.dulz.guideserver.entity.GuideEntity;
import com.dulz.guideserver.repo.GuideRepo;
import com.dulz.guideserver.util.DataConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional

public class GuideServiceIMPL implements GuideService{
    @Autowired
    DataConverter dataConverter;
    @Autowired
    GuideRepo guideRepo;

    @Override
    public void saveGuide(GuideDTO guideDTO) {
        if (guideRepo.existsById(guideDTO.getGuideId())){
            throw new RuntimeException(guideDTO.getGuideId() + " Guide Id Already Exists  !! ");
        }
        guideRepo.save(dataConverter.guideDTOToguideEntity(guideDTO));
    }


    @Override
    public void updateGuide(GuideDTO guideDTO) {
        if (!guideRepo.existsById(guideDTO.getGuideId())){
            throw new RuntimeException(guideDTO.getGuideId()+ " Guide Id Does Not Exists !! ");
        }
        guideRepo.save(dataConverter.guideDTOToguideEntity(guideDTO));
    }


    @Override
    public void deleteGuide(String id) {
        if (!guideRepo.existsById(id)){
            throw new RuntimeException(id+" Guide Id Does Not Exists !! ");
        }
        guideRepo.deleteById(id);
    }

    @Override
    public GuideDTO findById(String id) {
        if (!guideRepo.existsById(id)){
            throw new RuntimeException(id + " Guide Id Does Not Exists !!");
        }
        return dataConverter.guideEntityTOguideDTO(guideRepo.findById(id).get());
    }

    @Override
    public List<GuideDTO> getAll() {
        return dataConverter.guideEntityListToguideDTOList((List<GuideEntity>) guideRepo.findAll());
    }
}
