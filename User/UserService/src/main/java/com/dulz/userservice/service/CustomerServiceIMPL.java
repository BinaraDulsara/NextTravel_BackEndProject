package com.dulz.userservice.service;

import com.dulz.userservice.dto.CustomerDTO;
import com.dulz.userservice.entity.CustomerEntity;
import com.dulz.userservice.repo.CustomerRepo;
import com.dulz.userservice.util.DataConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    DataConverter dataConverter;

    @Autowired
    CustomerRepo customerRepo;

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getCustomerId())) {
            throw new RuntimeException(customerDTO.getCustomerId() + " Customer Id Already Exists !!");
        }
        customerRepo.save(dataConverter.CustomerDTOToCustomerEntity(customerDTO));
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        if (!customerRepo.existsById(customerDTO.getCustomerId())){
            throw new RuntimeException(customerDTO.getCustomerId()+" Customer Id Does Not Exists !! ");
        }
        customerRepo.save(dataConverter.CustomerDTOToCustomerEntity(customerDTO));
    }

    @Override
    public void deleteCustomer(String id) {
        if (!customerRepo.existsById(id)){
            throw new RuntimeException(id+" Customer Does Not Exists !! ");
        }
        customerRepo.deleteById(id);
    }

    @Override
    public CustomerDTO findById(String id) {
        if (!customerRepo.existsById(id)){
            throw new RuntimeException(id+" Customer Does Not Exists !! ");
        }
        return dataConverter.CustomerEntityToCustomerDTO(customerRepo.findById(id).get());
    }

    @Override
    public List<CustomerDTO> getAll() {
        return dataConverter.CustomerEntityListToCustomerDTOList(customerRepo.findAll());
    }
}
