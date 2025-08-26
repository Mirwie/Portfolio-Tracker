package com.example.portfolio.repository;


import com.example.portfolio.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StockRepository extends JpaRepository<Stock, Long> {
    boolean existsByTickerIgnoreCase(String ticker);
}