package com.dulz.packageserver.controller;

import com.dulz.packageserver.dto.PaymentDTO;
import com.dulz.packageserver.dto.ReportDTO;
import com.dulz.packageserver.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping(path = "/savePayment")
    public ResponseEntity<String> savePayment(@RequestBody PaymentDTO paymentDTO){
        paymentService.savePayment(paymentDTO);
        return new ResponseEntity<>(paymentDTO.getBookingId()+" Payment accepted..!!", HttpStatus.OK);
    }

    //get daily income
    @GetMapping(path = "/dailyIncome")
    public ResponseEntity<ArrayList<ReportDTO>> dailyIncome(){
        return new ResponseEntity<>(paymentService.dailyIncome(), HttpStatus.OK);
    }
    //get monthly Income
    @GetMapping(path = "/monthlyIncome")
    public ResponseEntity<ArrayList<ReportDTO>> monthlyIncome(){
        return new ResponseEntity<>(paymentService.monthlyIncome(), HttpStatus.OK);
    }
    //get annually income
    @GetMapping(path = "/AnnuallyIncome")
    public ResponseEntity<ArrayList<ReportDTO>> AnnuallyIncome(){
        return new ResponseEntity<>(paymentService.AnnuallyIncome(), HttpStatus.OK);
    }

}
