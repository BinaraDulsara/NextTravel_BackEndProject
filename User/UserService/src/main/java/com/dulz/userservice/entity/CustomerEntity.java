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
    private String CustomerId;
    private String Name;
    private String Email;
    private String Address;
    private String NIC;
    private String Username;
    private String Password;
    @Column(columnDefinition = "LONGTEXT")
    private String ProfilePic;
}
