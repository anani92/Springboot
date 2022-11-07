package com.axsos.dojosninjas.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.axsos.dojosninjas.models.Dojo;
import com.axsos.dojosninjas.repository.DojosRepo;

@Service
public class DojoService {
	private final DojosRepo dojoRepo;

	public DojoService(DojosRepo dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	public List <Dojo> allDojos(){
		return dojoRepo.findAll();
	}
	
	public Dojo findDojo(Long id) {
		Optional <Dojo> dojo = dojoRepo.findById(id);
		if(dojo.isPresent()) {
            return dojo.get();
        } else {
            return null;
        }
	}
	public Dojo create(@Valid Dojo dojo) {
		return dojoRepo.save(dojo);
	}
}
