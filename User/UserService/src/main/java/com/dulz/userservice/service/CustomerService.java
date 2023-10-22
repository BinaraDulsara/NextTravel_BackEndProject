package com.dulz.userservice.service;


import com.dulz.userservice.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    void saveCustomer(CustomerDTO customerDTO);

    void updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(String id);

    CustomerDTO findById(String id);

    List<CustomerDTO> getAll();

}
