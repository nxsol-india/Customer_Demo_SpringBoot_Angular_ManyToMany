package com.nxpert.CustomerDemo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nxpert.CustomerDemo.model.Customer;
import com.nxpert.CustomerDemo.repository.CustomerRepository;
import com.nxpert.CustomerDemo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository reopository;

	@Override
	public Page<Customer> search(Pageable pageable, String searchText) {
		String queriableText = new StringBuilder("%").append(searchText).append("%").toString();
		return reopository.search(pageable, queriableText);
	}

	@Override
	public Page<Customer> readAll(Pageable pageable) {
		Page<Customer> customerList = reopository.findAll(pageable);
		return customerList;
	}

	@Override
	public Optional<Customer> read(Integer id) {
		return reopository.findById(id);
	}

	@Override
	public Customer create(Customer request) {
		return reopository.save(request);
	}

	@Override
	public Customer update(Customer request) {
		return reopository.saveAndFlush(request);
	}

	@Override
	public void delete(Integer id) {
		reopository.deleteById(id);
	}

	@Override
	public Page<Customer> readByConsultantId(Pageable pageable, Integer id) {
		Page<Customer> pa = reopository.readByConsultantId(pageable, id);
		return reopository.readByConsultantId(pageable, id);
	}

}
