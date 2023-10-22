package com.dulz.userservice.controller;

import com.dulz.userservice.dto.UserDTO;
import com.dulz.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<String>saveUser(@RequestBody UserDTO userDTO){
        userService.saveUser(userDTO);
        return new ResponseEntity<>(userDTO.getUserId()+" User Saved !! ", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String>updateUser(@RequestBody UserDTO userDTO){
        userService.updateUser(userDTO);
        return new ResponseEntity<>(userDTO.getUserId()+" User Updated !! ",HttpStatus.OK);

    }

    @DeleteMapping(params ="id")
    public ResponseEntity<String>deleteUser(String id){
        userService.deleteUser(id);
        return new ResponseEntity<>(id+" User Deleted !!",HttpStatus.OK);
    }

    @GetMapping(params = "id")
    public ResponseEntity<UserDTO>findById(String id){
        return new ResponseEntity<>(userService.findById(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>>getAll(){
        return new ResponseEntity<>(userService.getAll(),HttpStatus.OK);
    }

}
