package com.axsos.dojosninjas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.dojosninjas.models.Ninja;

@Repository
public interface NinjasRepo extends CrudRepository <Ninja, Long>{
	List <Ninja>  findAll();
}
