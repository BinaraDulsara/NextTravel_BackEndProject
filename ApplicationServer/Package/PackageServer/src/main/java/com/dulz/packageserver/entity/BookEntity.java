package com.dulz.packageserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookEntity {
        @Id
        private String bookingId;
        private String packageId;
        private String startDate;
        private String endDate;
        private String nightCount;
        private String dayCount;
        private String adultsCount;
        private String childrenCount;

}
