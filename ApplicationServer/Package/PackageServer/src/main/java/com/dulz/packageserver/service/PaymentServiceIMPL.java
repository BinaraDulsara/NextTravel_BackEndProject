package com.dulz.packageserver.service;

import com.dulz.packageserver.dto.PaymentDTO;
import com.dulz.packageserver.dto.ReportDTO;
import com.dulz.packageserver.repo.PaymentRepo;
import com.dulz.packageserver.util.DataConverter;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class PaymentServiceIMPL implements PaymentService{

    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    DataConverter dataConverter;

    @Override
    public void savePayment(PaymentDTO paymentDTO) {
        if (paymentRepo.existsById(paymentDTO.getBookingId())) {
            throw new RuntimeException(paymentDTO.getBookingId() + " Payment is already Done !!");
        }
        paymentRepo.save(dataConverter.paymentDtoToPaymentEntity(paymentDTO));
    }


    @Override
    public void updatePayment(PaymentDTO paymentDTO) {
        if (!paymentRepo.existsById(paymentDTO.getBookingId())) {
            throw new RuntimeException(paymentDTO.getBookingId() + " Cannot find Payment !! ");
        }
        paymentRepo.save(dataConverter.paymentDtoToPaymentEntity(paymentDTO));
    }


    @Override
    public void deletePayment(String bookingId) {
        if (!paymentRepo.existsById(bookingId)) {
            throw new RuntimeException(bookingId + " Cannot find Payment !! ");
        }
        paymentRepo.deleteById(bookingId);
    }

    @Override
    public PaymentDTO findById(String bookingId) {
        if (!paymentRepo.existsById(bookingId)) {
            throw new RuntimeException(bookingId + " Cannot find Payment !! ");
        }
        return dataConverter.paymentEntityToPaymentDto(paymentRepo.findById(bookingId).get());
    }


    @Override
    public List<PaymentDTO> getAllPayments() {
        return dataConverter.paymentEntityListToPaymentDTOList(paymentRepo.findAll());
    }

    @Override
    public ArrayList<ReportDTO> monthlyIncome() {
        return paymentRepo.monthlyIncome();
    }

    @Override
    public ArrayList<ReportDTO> AnnuallyIncome() {
        return paymentRepo.AnnuallyIncome();
    }

    @Override
    public ArrayList<ReportDTO> dailyIncome() {
        return paymentRepo.dailyIncome();
    }
}
