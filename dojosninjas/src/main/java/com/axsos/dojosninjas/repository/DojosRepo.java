package com.axsos.dojosninjas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.dojosninjas.models.Dojo;

@Repository
public interface DojosRepo extends CrudRepository <Dojo, Long>{
	List <Dojo>  findAll();
	
	
}
