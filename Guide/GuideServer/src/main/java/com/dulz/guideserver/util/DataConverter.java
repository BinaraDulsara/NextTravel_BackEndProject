package com.dulz.guideserver.util;

import com.dulz.guideserver.dto.GuideDTO;
import com.dulz.guideserver.entity.GuideEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataConverter {

    @Autowired
    ModelMapper modelMapper;

    public GuideEntity guideDTOToguideEntity(GuideDTO guideDTO){
       return modelMapper.map(guideDTO, GuideEntity.class);
    }
    public GuideDTO guideEntityTOguideDTO(GuideEntity guideEntity){
        return modelMapper.map(guideEntity, GuideDTO.class);
    }

    public List<GuideDTO> guideEntityListToguideDTOList(List<GuideEntity> guides){
        return modelMapper.map(guides,new TypeToken<List<GuideDTO>>(){}.getType());
    }
}
