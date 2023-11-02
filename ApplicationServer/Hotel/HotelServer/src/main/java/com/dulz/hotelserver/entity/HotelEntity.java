package com.dulz.hotelserver.entity;

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
public class HotelEntity {
        @Id
        private String hotelId;
        private String hotelLocation;
        private String hotelName;
        private String coordinates;
        private String starRate;
        private String packageCategory;
        private String hotelContactNumber1;
        private String hotelContactNumber2;
        private  String petsAllowedOrNot;
        private  String cancelCriteria;
        private  double hotelFee;
        private String email;
        @Column(columnDefinition = "LONGTEXT")
        private String image;



}
