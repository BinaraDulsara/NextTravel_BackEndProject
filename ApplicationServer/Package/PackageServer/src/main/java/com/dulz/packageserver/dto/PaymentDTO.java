package com.dulz.packageserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PaymentDTO {

    private String bookingId;
    private String customerId;
    private Date date;
    private double price;
    private String paymentSlip;
}
