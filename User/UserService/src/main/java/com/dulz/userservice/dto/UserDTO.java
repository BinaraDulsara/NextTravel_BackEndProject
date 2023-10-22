package com.dulz.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {

    private String UserId;
    private String Name;
    private String NIC;
    private int Age;
    private String Gender;
    private String Email;
    private String ContactNumber;
    private String Address;
    private String Role;

}
