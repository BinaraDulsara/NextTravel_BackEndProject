package com.dulz.guideserver.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GuideEntity {
    @Id
    private String guideId;
    private String guideName;
    private String address;
    private String gender;
    private String number;
    private String experience;
    private double manDayValue;
    private String guideImage;
    private String nicImage;
    private String GuideIDImage;

}
