package com.axsos.roaster.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.roaster.models.Dorm;

@Repository
public interface DormRepo extends CrudRepository <Dorm, Long>{
	List <Dorm> findAll();
}
