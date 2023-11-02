package com.dulz.userservice.service;

import com.dulz.userservice.dto.UserDTO;
import com.dulz.userservice.repo.UserRepo;
import com.dulz.userservice.util.DataConverter;
import com.dulz.userservice.util.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(UserDTO userDTO) {
        if (userRepo.existsById(userDTO.getUserId()))
            throw new RuntimeException(userDTO.getUserId()+" User already in the system..!! ");
        if (userRepo.existsByEmail(userDTO.getEmail()))
            throw new RuntimeException(userDTO.getEmail()+" User Not in the system..!! ");
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userRepo.save(dataConverter.UserDTOToUserEntity(userDTO));
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        if (!userRepo.existsById(userDTO.getUserId()))
            throw new RuntimeException(userDTO.getUserId()+" User Not in the system..!! ");
        if (!userRepo.existsByEmail(userDTO.getEmail()))
            throw new RuntimeException(userDTO.getEmail()+" User Not in the system..!! ");
        userRepo.save(dataConverter.UserDTOToUserEntity(userDTO));
    }

    @Override
    public void deleteUser(String userEmail) {
        if (!userRepo.existsByEmail(userEmail))
            throw new RuntimeException(userEmail+" User Not in the system..!! ");
        userRepo.deleteByEmail(userEmail);
    }

    @Override
    public UserDTO userFindByEmail(String email) {
        if (!userRepo.existsByEmail(email))
            throw new RuntimeException(email+" User Not in the system..!! ");
        return dataConverter.UserEntityToUserDTO(userRepo.findByEmail(email).get());
    }

    @Override
    public List<UserDTO> getAll() {
        return dataConverter.UserEntityListToUserDTOList(userRepo.findAll());
    }

    @Override
    public int countByRoleType(RoleType roleType) {
        return userRepo.countByRoleType(roleType);
    }

    @Override
    public String getLastIndex() {
        return userRepo.getLastIndex();
    }

}
