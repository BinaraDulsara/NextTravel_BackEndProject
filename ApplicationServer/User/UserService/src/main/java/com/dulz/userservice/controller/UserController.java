package com.dulz.userservice.controller;

import com.dulz.userservice.dto.UserDTO;
import com.dulz.userservice.service.UserService;
import com.dulz.userservice.util.RoleType;
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

    @PostMapping("/saveUser")
    public ResponseEntity<String> saveUser(@RequestBody UserDTO userDTO){
        userService.saveUser(userDTO);
        return new ResponseEntity<>(userDTO.getUserId()+" User Saved !!", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateUser(@RequestBody UserDTO userDTO){
        userService.updateUser(userDTO);
        return new ResponseEntity<>(userDTO.getUserId()+" User Updated..!!", HttpStatus.OK);
    }

    @GetMapping(params = "userEmail",path = "/getUser")
    public ResponseEntity<UserDTO> userFindByEmail(String userEmail){
        return new ResponseEntity<>(userService.userFindByEmail(userEmail),HttpStatus.OK);
    }

    @DeleteMapping(params = "userEmail")
    public ResponseEntity<String> deleteUser(String userEmail){
        userService.deleteUser(userEmail);
        return new ResponseEntity<>(userEmail+" User deleted..!!",HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>>getAll(){
        return new ResponseEntity<>(userService.getAll(),HttpStatus.OK);
    }

    //get Count by users by Role type(number of admins,users and customers)
    @GetMapping(params = "roleType",path = "/countByRoleType")
    public ResponseEntity<Integer> countByRoleType(RoleType roleType){
        return new ResponseEntity<>(userService.countByRoleType(roleType),HttpStatus.OK);
    }

    //get last index of userId
    @GetMapping(path = "/getLastId")
    public ResponseEntity<String> getLastId(){
        return new ResponseEntity<>(userService.getLastIndex(),HttpStatus.OK);
    }

}
