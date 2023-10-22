package com.dulz.userservice.repo;

import com.dulz.userservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity,String> {

}
