package com.dulz.packageserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BookDTO {
    private String bookingId;
    private String packageId;
    private String startDate;
    private String endDate;
    private String nightCount;
    private String dayCount;
    private String adultsCount;
    private String childrenCount;
}