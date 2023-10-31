package com.dulz.guideserver.repo;

import com.dulz.guideserver.entity.GuideEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuideRepo extends JpaRepository<GuideEntity,String> {
}
