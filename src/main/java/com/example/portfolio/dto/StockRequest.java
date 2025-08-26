package com.example.portfolio.dto;


import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;


public record StockRequest(
        @NotBlank String ticker,
        @NotBlank String name,
        @Positive Integer quantity,
        @Positive BigDecimal buyPrice,
        @PastOrPresent LocalDate buyDate
) {}