package com.dulz.userservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CustomerEntity {
    @Id
    private String customerId;
    private String name;
    private String email;
    private String address;
    private String nic;
    private String username;
    private String password;
    @Column(columnDefinition = "LONGTEXT")
    private String profilePic;
}
