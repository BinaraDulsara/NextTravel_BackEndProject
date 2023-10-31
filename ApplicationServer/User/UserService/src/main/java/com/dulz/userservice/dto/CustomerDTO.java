package com.dulz.userservice.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomerDTO {
    private String customerId;
    private String name;
    private String email;
    private String address;
    private String nic;
    private String username;
    private String password;
    private String profilePic;
}
