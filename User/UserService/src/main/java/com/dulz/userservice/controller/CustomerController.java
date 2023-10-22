package com.dulz.userservice.controller;

import com.dulz.userservice.dto.CustomerDTO;
import com.dulz.userservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")

public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity<String>saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
        return new ResponseEntity<>(customerDTO.getCustomerId()+" Customer Saved ", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String>updateCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.updateCustomer(customerDTO);
        return new ResponseEntity<>(customerDTO.getCustomerId()+" Customer Updated ", HttpStatus.OK);
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<String>deleteCustomer(String id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(id+" Customer Deleted ",HttpStatus.OK);
    }

    @GetMapping(params = "id")
    public ResponseEntity<CustomerDTO>findById(String id){
        return new ResponseEntity<>(customerService.findById(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>>getAll(){
        return new ResponseEntity<>(customerService.getAll(),HttpStatus.OK);
    }


}
