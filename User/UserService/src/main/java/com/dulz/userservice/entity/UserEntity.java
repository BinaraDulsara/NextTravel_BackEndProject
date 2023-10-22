package com.dulz.userservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserEntity {
    @Id
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
