package com.dulz.packageserver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class PackageEntity {
    @Id
    private String packageId;
    private String packageCategory;
    private int nightCount;
    private int dayCount;
    private int totalHeadCount;
    private double price;
    @OneToMany(mappedBy = "aPackage",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    List<BookEntity> bookings = new ArrayList<>();
}
