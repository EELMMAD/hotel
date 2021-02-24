package se.lexicon.groupProject.hotel.service;

import se.lexicon.groupProject.hotel.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    CustomerDTO findById(String customerId);

    CustomerDTO findByEmail(String customerEmail);

    List<CustomerDTO> findAll();

    CustomerDTO create(CustomerDTO customerDTO);

    CustomerDTO update(CustomerDTO customerDTO);

    boolean delete(String customerId);
}
