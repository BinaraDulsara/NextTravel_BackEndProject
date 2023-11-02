package com.dulz.packageserver.service;

import com.dulz.packageserver.dto.PaymentDTO;
import com.dulz.packageserver.dto.ReportDTO;

import java.util.ArrayList;
import java.util.List;

public interface PaymentService {
    void savePayment(PaymentDTO paymentDTO);
    void updatePayment(PaymentDTO paymentDTO);
    void deletePayment(String bookingId);
    PaymentDTO findById(String bookingId);
    List<PaymentDTO> getAllPayments();
    ArrayList<ReportDTO> monthlyIncome();
    ArrayList<ReportDTO> AnnuallyIncome();
    ArrayList<ReportDTO> dailyIncome();

}
