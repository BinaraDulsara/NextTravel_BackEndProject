package com.dulz.userservice.service;

import com.dulz.userservice.dto.CustomerDTO;
import com.dulz.userservice.dto.UserDTO;
import com.dulz.userservice.entity.UserEntity;
import com.dulz.userservice.repo.UserRepo;
import com.dulz.userservice.util.DataConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class UserServiceIMPL implements UserService{

    @Autowired
    UserRepo userRepo;

    @Autowired
    DataConverter dataConverter;


    @Override
    public void saveUser(UserDTO userDTO) {
        if (userRepo.existsById(userDTO.getUserId())){
            throw new RuntimeException(" User ID already exists");
        }
        userRepo.save(dataConverter.UserDTOToUserEntity(userDTO));
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        if(!userRepo.existsById(userDTO.getUserId())){
            throw new RuntimeException(userDTO.getUserId()+" User Id Does Not Exits !! ");
        }
        userRepo.save(dataConverter.UserDTOToUserEntity(userDTO));
    }

    @Override
    public void deleteUser(String id) {
        if (!userRepo.existsById(id)){
            throw new RuntimeException(id+" User Id Does Not Exists !! ");
        }
        userRepo.deleteById(id);
    }

    @Override
    public UserDTO findById(String id) {
        if (!userRepo.existsById(id)){
            throw new RuntimeException(id+" User Id Does Not Exists ");
        }
        return dataConverter.UserEntityToUserDTO(userRepo.findById(id).get());

    }
    @Override
    public List<UserDTO> getAll() {
        return dataConverter.UserEntityListToUserDTOList(userRepo.findAll());
    }
}
