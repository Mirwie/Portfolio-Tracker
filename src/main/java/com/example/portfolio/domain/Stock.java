package com.example.portfolio.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;


import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "stocks")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank
    @Column(nullable = false, length = 20)
    private String ticker; // oder ISIN/WKN – MVP: Ticker


    @NotBlank
    @Column(nullable = false)
    private String name;


    @Positive
    @Column(nullable = false)
    private Integer quantity; // Stückzahl


    @Positive
    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal buyPrice; // Kaufkurs je Stück


    @PastOrPresent
    @Column(nullable = false)
    private LocalDate buyDate; // Kaufdatum
}