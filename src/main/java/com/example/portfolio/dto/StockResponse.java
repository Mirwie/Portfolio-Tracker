package com.example.portfolio.dto;


import java.math.BigDecimal;
import java.time.LocalDate;


public record StockResponse(
        Long id,
        String ticker,
        String name,
        Integer quantity,
        BigDecimal buyPrice,
        LocalDate buyDate
) {}