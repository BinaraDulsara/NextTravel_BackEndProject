package com.dulz.packageserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookEntity {
        @Id
        private String bookingId;
        private String guideId;
        private String userId;
        private LocalDate currentlyDate;
        private String startDate;
        private String endDate;
        private String nightCount;
        private String dayCount;
        private String adultsCount;
        private String childrenCount;
        @ManyToOne
        @JoinColumn(name = "packageId",referencedColumnName = "packageId")
        PackageEntity aPackage;


}
