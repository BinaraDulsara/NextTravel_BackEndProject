package com.dulz.userservice.service;

import com.dulz.userservice.dto.CustomerDTO;
import com.dulz.userservice.dto.UserDTO;

import java.util.List;

public interface UserService {

    void saveUser(UserDTO userDTO);

    void updateUser(UserDTO userDTO);

    void deleteUser(String id);

    UserDTO findById(String id);

    List<UserDTO> getAll();

}
