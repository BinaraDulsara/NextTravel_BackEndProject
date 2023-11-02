package com.dulz.userservice.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {

    private String userId;
    private String name;
    private String nic;
    private int age;
    private String gender;
    private String email;
    @Enumerated(EnumType.STRING)
    private String roleType;
    private String password;
    private String contactNumber;
    private String address;
    @Column(columnDefinition = "LONGTEXT")
    private String  profilePic;


}
