package ru.gb.Seminar0051.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
public class Account {
    @Id
    private Long id;
    private String name;
    private BigDecimal amount;
}
