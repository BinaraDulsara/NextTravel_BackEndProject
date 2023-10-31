package com.dulz.guideserver.repo;

import com.dulz.guideserver.entity.GuideEntity;
import org.springframework.data.repository.CrudRepository;

public interface GuideRepo extends CrudRepository<GuideEntity,String> {
}
