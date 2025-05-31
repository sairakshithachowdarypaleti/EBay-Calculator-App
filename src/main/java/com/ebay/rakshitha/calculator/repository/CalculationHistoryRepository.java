package com.ebay.rakshitha.calculator.repository;

import com.ebay.rakshitha.calculator.model.CalculatorHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculationHistoryRepository extends JpaRepository<CalculatorHistory, Long> {
}
