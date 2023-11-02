package com.dulz.guideserver.repo;

import com.dulz.guideserver.entity.GuideEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GuideRepo extends CrudRepository<GuideEntity,String> {
    GuideEntity findByGuideId(String guideId);

    List<GuideEntity> findAll();

}
