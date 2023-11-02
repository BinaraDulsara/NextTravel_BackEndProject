package com.dulz.userservice.repo;

import com.dulz.userservice.entity.UserEntity;
import com.dulz.userservice.util.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity,String> {

    @Query(value = "SELECT userId FROM User ORDER BY userId DESC LIMIT 1",nativeQuery = true)
    String getLastIndex();
    boolean existsByEmail(String email);
    void deleteByEmail(String userEmail);
    Optional<UserEntity> findByEmail(String email);
    int countByRoleType(RoleType roleType);
}
