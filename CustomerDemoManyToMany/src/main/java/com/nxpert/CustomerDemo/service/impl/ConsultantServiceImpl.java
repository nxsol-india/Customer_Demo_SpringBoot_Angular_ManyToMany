package com.nxpert.CustomerDemo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nxpert.CustomerDemo.model.Consultant;
import com.nxpert.CustomerDemo.repository.ConsultantRepository;
import com.nxpert.CustomerDemo.service.ConsultantService;

@Service
public class ConsultantServiceImpl implements ConsultantService {

	@Autowired
	ConsultantRepository reopository;

	@Override
	public Page<Consultant> search(Pageable pageable, String searchText) {
		// TODO Auto-generated method stub
		String queriableText = new StringBuilder("%").append(searchText).append("%").toString();
		return reopository.search(pageable, queriableText);
	}
	
	@Override
	public Page<Consultant> readAll(Pageable pageable) {
		return reopository.findAll(pageable);
	}
	
	@Override
	public Optional<Consultant> read(Integer id) {
		return reopository.findById(id);
	}
	
	@Override
	public Consultant create(Consultant request) {
		return reopository.save(request);
	}

	@Override
	public Consultant update(Consultant request) {
		return reopository.saveAndFlush(request);
	}

	@Override
	public void delete(Integer id) {
		reopository.deleteById(id);
	}

	@Override
	public Page<Consultant> readByCoustomerId(Pageable pageable, Integer id) {
		return reopository.readAllByCustomerId(pageable, id);
	}

	@Override
	public List<Consultant> readAll() {
		return reopository.findAll();
	}

}
