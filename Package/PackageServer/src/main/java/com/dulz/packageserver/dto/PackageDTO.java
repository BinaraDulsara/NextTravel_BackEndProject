package com.dulz.packageserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PackageDTO {
    private String packageId;
    private String packageCategory;
    private int nightCount;
    private String travelArea;
    private int totalHeadCount;
    private boolean petStatus;
    private double price;
}
