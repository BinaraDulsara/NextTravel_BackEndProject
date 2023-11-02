package com.dulz.userservice.service;

import com.dulz.userservice.dto.UserDTO;
import com.dulz.userservice.util.RoleType;

import java.util.List;

public interface UserService {

    void saveUser(UserDTO userDTO);

    void updateUser(UserDTO userDTO);

    void deleteUser(String email);

    UserDTO userFindByEmail(String id);

    List<UserDTO> getAll();
    int countByRoleType(RoleType roleType);
    String getLastIndex();

}
