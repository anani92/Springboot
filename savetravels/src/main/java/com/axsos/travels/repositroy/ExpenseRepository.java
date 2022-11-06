package com.axsos.travels.repositroy;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.travels.model.Expense;

@Repository

public interface ExpenseRepository extends CrudRepository <Expense, Long>{
	List<Expense> findAll();
}
