package com.dulz.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomerDTO {
    private String CustomerId;
    private String Name;
    private String Email;
    private String Address;
    private String NIC;
    private String Username;
    private String Password;
    private String ProfilePic;
}
