package com.axsos.travels.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.axsos.travels.model.Expense;
import com.axsos.travels.repositroy.ExpenseRepository;
@Service

public class ExpenseService {
	private final ExpenseRepository expenseRepository;
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	public List<Expense> allExpenses() {
		return expenseRepository.findAll();
	}
	
	public Expense createExpense(Expense expense) {
		
		return expenseRepository.save(expense);
	}
}
