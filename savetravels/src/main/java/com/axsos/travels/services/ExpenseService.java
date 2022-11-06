package com.axsos.travels.services;

import java.util.List;
import java.util.Optional;

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
	public Expense findExpense(Long id) {
		Optional <Expense> expense = expenseRepository.findById(id);
		if(expense.isPresent()) {
            return expense.get();
        } else {
            return null;
        }
	}
	
	public Expense updateExpense(Long id, Expense expense) {
		Expense expenseToEdit = findExpense(id);
		expenseToEdit.setExpenseName(expense.getExpenseName());
		expenseToEdit.setVendor(expense.getVendor());
		expenseToEdit.setDescription(expense.getDescription());
		expenseToEdit.setAmount(expense.getAmount());
		expenseRepository.save(expenseToEdit);
		return expenseToEdit;

	}
}
