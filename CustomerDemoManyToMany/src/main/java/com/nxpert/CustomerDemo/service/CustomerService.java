package com.nxpert.CustomerDemo.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nxpert.CustomerDemo.model.Customer;

public interface CustomerService  {

	Page<Customer> search(Pageable pageable, String searchText);
	
	Page<Customer> readAll(Pageable pageable);
	
	Optional<Customer> read(Integer id);
	
	Customer create(Customer request);

	Customer update(Customer request);

	void delete(Integer id);

	Page<Customer> readByConsultantId(Pageable pageable, Integer id);
}
