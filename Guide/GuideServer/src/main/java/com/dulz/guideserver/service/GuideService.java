package com.dulz.guideserver.service;

import com.dulz.guideserver.dto.GuideDTO;

import java.util.List;

public interface GuideService {
    void saveGuide(GuideDTO guideDTO);
    void updateGuide(GuideDTO guideDTO);
    void deleteGuide(String id);
    GuideDTO findById(String id);
    List<GuideDTO> getAll();

}
