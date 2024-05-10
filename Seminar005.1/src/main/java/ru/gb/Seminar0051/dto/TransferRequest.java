package ru.gb.Seminar0051.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferRequest {
    private Long senderAccountId;
    private Long receiverAccountId;
    private BigDecimal amount;
}
