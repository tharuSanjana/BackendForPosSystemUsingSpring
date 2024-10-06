package lk.ijse.backendforpossystemusingspring.service;

import lk.ijse.backendforpossystemusingspring.dto.impl.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);
    void  updateCustomer(String customerId,CustomerDTO customerDTO);
    void  deleteCustomer(String customerId);
    List<CustomerDTO> getAllCustomers();
}
