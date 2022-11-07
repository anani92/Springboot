package com.axsos.dojosninjas.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.dojosninjas.models.Ninja;
import com.axsos.dojosninjas.repository.NinjasRepo;



@Service
public class NinjaService {
	private final NinjasRepo ninjasRepo;
	public NinjaService(NinjasRepo ninjasRepo) {
		this.ninjasRepo = ninjasRepo;
	}
	public Ninja findninja(Long id) {
		Optional <Ninja> ninja = ninjasRepo.findById(id);
		if(ninja.isPresent()) {
            return ninja.get();
        } else {
            return null;
        }
	}
	
	public Ninja createNinja(Ninja ninja) {
		return ninjasRepo.save(ninja);
	}
}
