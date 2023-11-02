package com.dulz.userservice.util;

import com.dulz.userservice.dto.UserDTO;
import com.dulz.userservice.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataConverter {

    @Autowired
    ModelMapper modelMapper;

    public UserEntity UserDTOToUserEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, UserEntity.class);
    }

    public UserDTO UserEntityToUserDTO(UserEntity userEntity){
        return modelMapper.map(userEntity, UserDTO.class);
    }

    public List<UserDTO> UserEntityListToUserDTOList(List<UserEntity> users){
        return modelMapper.map(users,new TypeToken<List<UserDTO>>(){}.getType());
    }

}
