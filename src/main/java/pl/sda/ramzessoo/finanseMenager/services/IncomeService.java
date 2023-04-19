package pl.sda.ramzessoo.finanseMenager.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import pl.sda.ramzessoo.finanseMenager.DbConnection;
import pl.sda.ramzessoo.finanseMenager.entity.Income;
import pl.sda.ramzessoo.finanseMenager.repository.IncomeRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class IncomeService {

    private final IncomeRepository incomeRepository;

    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    public void addIncome(Long quota, LocalDate addDate, String comment){
        Income income = new Income(quota, addDate, comment);
        income.setQuota(quota);
        income.setAddDate(addDate);
        income.setComment(comment);
        incomeRepository.insert(income);
    }

    public Set<Income> findAll() {
        Set<Income> incomes = incomeRepository.findAll();
        return incomes;
    }

    public void removeIncome(Income income) {
        incomeRepository.remove(income.getId());
    }
}
