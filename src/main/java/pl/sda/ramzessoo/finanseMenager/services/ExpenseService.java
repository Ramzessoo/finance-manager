package pl.sda.ramzessoo.finanseMenager.services;

import pl.sda.ramzessoo.finanseMenager.entity.Category;
import pl.sda.ramzessoo.finanseMenager.entity.Expense;
import pl.sda.ramzessoo.finanseMenager.repository.ExpenseRepository;

import java.time.LocalDate;

public class ExpenseService {

    private final ExpenseRepository expenceRepository;

    public ExpenseService(ExpenseRepository expenceRepository) {
        this.expenceRepository = expenceRepository;
    }

    public void addExpense(Long quota, Category categoryId, LocalDate addDate, String comment){
        Expense expense = new Expense(quota, categoryId, addDate, comment);
        expense.setQuota(quota);
        expense.setCategoryId(categoryId);
        expense.setAddDate(addDate);
        expense.setComment(comment);
        expenceRepository.insert(expense);
    }

    public void removeExpense(Expense expense) {
        expenceRepository.remove(expense.getId());
    }
}
